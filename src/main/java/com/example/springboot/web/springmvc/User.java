package com.example.springboot.web.springmvc;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private int age;
    private Date birth;
    private String password;
}

