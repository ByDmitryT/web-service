import {CHANGE_SALARY, CREATE_EMPLOYEE, DELETE_EMPLOYEES, GET_EMPLOYEES} from "../const";

const REST_URL = "http://localhost:8080/rest";

export const createEmployee = (dispatch) => (employee) => {
    fetch(REST_URL + "/employee", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    })
        .then(response => response.json())
        .then(data => {
            dispatch({
                type: CREATE_EMPLOYEE,
                payload: data
            })
        })

};

export const getEmployees = (dispatch) => () => {
    fetch(REST_URL + "/employees")
        .then(response => response.json())
        .then(data => {
            dispatch({
                type: GET_EMPLOYEES,
                payload: data
            });
        })
};

export const deleteEmployees = (dispatch) => () => {
    fetch(REST_URL + "/employees", {method: 'DELETE'})
        .then(response => {
            if (response.ok) {
                dispatch({
                    type: DELETE_EMPLOYEES
                })
            }
        })
};

export const changeSalary = (dispatch) => (salary) => {
    fetch(REST_URL + "/salary/" + salary.id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(salary)
    })
        .then(response => {
            if (response.ok) {
                dispatch({
                    type: CHANGE_SALARY,
                    payload: salary
                })
            }
        })

};