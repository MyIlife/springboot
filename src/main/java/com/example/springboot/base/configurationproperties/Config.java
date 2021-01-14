package com.example.springboot.base.configurationproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "config")
@EnableConfigurationProperties(CPTest1.class)
public class Config {
    private int test1;
    private String test2;

    @Bean
    public CPTest2 cPTest2(){
        CPTest2 c = new CPTest2();
        c.setAge(22);
        c.setName("dsd");
        c.setTest1(test1);
        c.setTest2(test2);
        return c;
    }

}
