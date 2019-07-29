import React from 'react';
import {Button} from 'react-bootstrap';

class EmployeeItem extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            sum: props.employee && props.employee.salary && props.employee.salary.sum
        };
    }

    handleChange = (e) => {
        this.setState({sum: e.target.value});
    };

    handleClick = () => {
        this.props.onSave({
            id: this.props.employee.salary.id,
            sum: this.state.sum
        });
    };

    handleKeyPress = (e) => {
        if (!/[0-9]/.test(e.key))
            e.preventDefault();
    };

    render() {
        const {
            employee,
            employeeNumber,
        } = this.props;
        const {sum} = this.state;

        return (
            <tr>
                <td>{employeeNumber + 1}</td>
                <td>{employee.name}</td>
                <td>
                    <input
                        value={sum}
                        onChange={this.handleChange}
                        onKeyPress={this.handleKeyPress}
                    />
                </td>
                <td>
                    <Button variant="dark" onClick={this.handleClick}>Сохранить</Button>
                </td>
            </tr>
        )
    }
}

export default EmployeeItem;
