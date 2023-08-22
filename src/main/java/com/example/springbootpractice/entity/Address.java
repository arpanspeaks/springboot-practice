package com.example.springbootpractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String streetName;

    private String houseNumber;

    @Column(nullable = false)
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
