package ru.titov.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.titov.webservice.api.service.EmployeeService;
import ru.titov.webservice.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping("/employees")
    public void deleteEmployees() {
        employeeService.deleteEmployees();
    }

}
