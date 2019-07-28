package ru.titov.webservice.api.service;

import ru.titov.webservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getEmployees();

    void deleteEmployees();

}
