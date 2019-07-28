package ru.titov.webservice.api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.titov.webservice.entity.Salary;

public interface SalaryRepository extends CrudRepository<Salary, String> {
}
