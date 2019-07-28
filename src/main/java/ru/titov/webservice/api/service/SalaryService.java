package ru.titov.webservice.api.service;

import ru.titov.webservice.entity.Salary;
import ru.titov.webservice.exception.SalaryNotFoundException;

public interface SalaryService {

    Salary createSalary(Salary salary);

    void changeSalary(String id, Salary salary) throws SalaryNotFoundException;

}
