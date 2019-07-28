package ru.titov.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.titov.webservice.api.repository.EmployeeRepository;
import ru.titov.webservice.api.service.EmployeeService;
import ru.titov.webservice.api.service.SalaryService;
import ru.titov.webservice.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final SalaryService salaryService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, SalaryService salaryService) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
    }

    @Transactional
    @Override
    public Employee createEmployee(Employee employee) {
        final Employee newEmployee = employee == null ? new Employee() : employee;
        newEmployee.setSalary(salaryService.createSalary(newEmployee.getSalary()));
        return employeeRepository.save(newEmployee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteEmployees() {
        employeeRepository.deleteAll();
    }

}
