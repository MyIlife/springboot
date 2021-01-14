package com.example.springboot.base.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
@ConfigurationProperties(prefix = "config.test")
public class CPTest1 {
    private String name;
    private int age;
}
