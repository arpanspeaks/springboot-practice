package com.example.springbootpractice.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchRequest {

    private String firstname;
    private String lastname;
    private String email;

}
