package com.example.springbootpractice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    private String missionName;

    private int duration;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;

}
