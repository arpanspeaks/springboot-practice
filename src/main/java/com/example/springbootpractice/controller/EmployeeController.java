package com.example.springbootpractice.controller;

import com.example.springbootpractice.entity.Employee;
import com.example.springbootpractice.pojo.SearchRequest;
import com.example.springbootpractice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empServ;

    @GetMapping("/")
    public void findAllBySearchQuery() {
        List<Employee> employees =
                empServ.findAllBySearchQuery(
                        new SearchRequest("Arpan", "Sardar", "arpan@sardar.com")
                );
        employees.forEach(System.out::println);
    }

}
