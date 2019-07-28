package ru.titov.webservice.exception;

public class SalaryNotFoundException extends Exception {

    public SalaryNotFoundException(final String id) {
        super(String.format("Salary not found with id %s", id));
    }

}
