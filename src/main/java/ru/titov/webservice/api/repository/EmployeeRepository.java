package ru.titov.webservice.api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.titov.webservice.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findAll();

}
