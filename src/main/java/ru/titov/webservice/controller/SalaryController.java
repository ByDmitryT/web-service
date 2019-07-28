package ru.titov.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.titov.webservice.api.service.SalaryService;
import ru.titov.webservice.entity.Salary;
import ru.titov.webservice.exception.SalaryNotFoundException;

@RestController
@RequestMapping("/rest")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PutMapping("/salary/{id}")
    public void changeSalary(@PathVariable String id, @RequestBody Salary salary) throws SalaryNotFoundException {
        salaryService.changeSalary(id, salary);
    }

}
