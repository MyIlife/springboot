package com.example.springboot;

import com.example.springboot.base.configuration.ConfigTest1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@Component("") //指定扫描包
//@SpringBootApplication(scanBasePackages = "") //指定基础扫描包
@ServletComponentScan("com.example.springboot.web.otheranno")
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        //run.close();
    }
}
