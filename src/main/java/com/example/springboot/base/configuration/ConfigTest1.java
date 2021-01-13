package com.example.springboot.base.configuration;

import lombok.Data;

@Data
public class ConfigTest1 {
    private String name;
    private int age;
    private ConfigTest2 configTest2;
}
