package com.example.springbootpractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Mission {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String missionname;

    @Column(nullable = false)
    private int duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;

}
