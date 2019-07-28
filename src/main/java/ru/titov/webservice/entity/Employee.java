package ru.titov.webservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @Column(nullable = false)
    private String id = UUID.randomUUID().toString();

    @OneToOne(orphanRemoval=true)
    private Salary salary;

    @Column(nullable = false)
    private String name = "new";

}
