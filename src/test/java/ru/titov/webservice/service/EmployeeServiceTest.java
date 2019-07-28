package ru.titov.webservice.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.titov.webservice.api.repository.EmployeeRepository;
import ru.titov.webservice.api.service.EmployeeService;
import ru.titov.webservice.entity.Employee;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee();
        employee.setName("test");
        List<Employee> employees = Collections.singletonList(employee);

        Mockito.when(employeeRepository.findAll())
                .thenReturn(employees);
    }

    @Test
    public void getEmployees() {
        String name = "test";
        List<Employee> employees = employeeService.getEmployees();
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals(name, employees.get(0).getName());
    }
}