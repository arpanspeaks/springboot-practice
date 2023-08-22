package com.example.springbootpractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String deptname;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
