import React from 'react';
import './App.css';
import {Button, Form, Table} from 'react-bootstrap';
import {connect} from 'react-redux';
import {changeSalary, createEmployee, deleteEmployees, getEmployees} from '../../action'
import EmployeeItem from "../EmployeeItem/EmployeeItem";

class App extends React.Component {

    componentDidMount() {
        this.props.getEmployees();
    }

    handleSubmit = (e) => {
        e.preventDefault();
        const form = e.currentTarget;
        this.props.createEmployee({
            name: form[0].value || "new",
            salary: {
                sum: form[1].value
            }
        });
    };

    render() {
        const {
            employees,
            deleteEmployees,
            changeSalary
        } = this.props;

        return (
            <div className="app">
                <link
                    rel="stylesheet"
                    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                    crossOrigin="anonymous"
                />
                <h1>Список сотрудников</h1>
                <div className="create-form">
                    <Form onSubmit={this.handleSubmit}>
                        <Form.Group controlId="formGroupName">
                            <Form.Label>Имя</Form.Label>
                            <Form.Control type="text" placeholder="Введите имя"/>
                        </Form.Group>
                        <Form.Group controlId="formGroupSalary">
                            <Form.Label>Оклад</Form.Label>
                            <Form.Control type="number" placeholder="Введите оклад"/>
                        </Form.Group>
                        <Button variant="dark" type="submit">Создать</Button>
                    </Form>
                </div>
                <hr/>
                <div className="app-table">
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Имя</th>
                            <th>Оклад</th>
                            <th/>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            Array.isArray(employees) && employees.map((employee, key) => {
                                return (
                                    <EmployeeItem
                                        key={employee.id}
                                        employee={employee}
                                        employeeNumber={key}
                                        onSave={changeSalary}
                                    />
                                )
                            })
                        }
                        </tbody>
                    </Table>
                </div>
                <Button variant="danger" onClick={deleteEmployees}>Удалить всех</Button>
            </div>
        );
    }

}

const mapStateToProps = (state) => ({
    employees: state.employees
});

const mapDispatchToProps = (dispatch) => ({
    getEmployees: getEmployees(dispatch),
    createEmployee: createEmployee(dispatch),
    deleteEmployees: deleteEmployees(dispatch),
    changeSalary: changeSalary(dispatch)
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
