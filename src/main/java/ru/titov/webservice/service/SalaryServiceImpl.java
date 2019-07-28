package ru.titov.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.titov.webservice.api.repository.SalaryRepository;
import ru.titov.webservice.api.service.SalaryService;
import ru.titov.webservice.entity.Salary;
import ru.titov.webservice.exception.SalaryNotFoundException;

import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Transactional
    @Override
    public Salary createSalary(Salary salary) {
        final Salary newSalary = salary == null ? new Salary() : salary;
        return salaryRepository.save(newSalary);
    }

    @Transactional
    @Override
    public void changeSalary(String id, Salary salary) throws SalaryNotFoundException {
        final Optional<Salary> oldSalary = salaryRepository.findById(id);
        final Salary newSalary = oldSalary.orElseThrow(() -> new SalaryNotFoundException(id));
        newSalary.setSum(salary.getSum());
        salaryRepository.save(newSalary);
    }

}
