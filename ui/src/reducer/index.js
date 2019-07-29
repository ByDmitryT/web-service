import {CHANGE_SALARY, CREATE_EMPLOYEE, DELETE_EMPLOYEES, GET_EMPLOYEES} from "../const";

let defaultState = [];

const reducer = (state = defaultState, action) => {
    switch (action.type) {
        case CREATE_EMPLOYEE:
            return [...state, action.payload];
        case GET_EMPLOYEES:
            return action.payload;
        case DELETE_EMPLOYEES:
            return [];
        case CHANGE_SALARY:
            return [
                ...state.map(employee => {
                    if (employee.salary.id === action.payload.id) {
                        employee.salary.sum = action.payload.sum
                    }
                    return employee
                })
            ];
        default:
            return state;
    }
};

export default reducer;