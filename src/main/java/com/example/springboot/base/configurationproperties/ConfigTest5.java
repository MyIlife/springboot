package com.example.springboot.base.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class ConfigTest5 {
    private String name;
    private int age;
    private int test1;
    private String test2;
}
