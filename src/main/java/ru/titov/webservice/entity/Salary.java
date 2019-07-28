package ru.titov.webservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Salary {

    @Id
    @Column(nullable = false)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private int sum;

}

