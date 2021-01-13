package com.example.springboot;

import com.example.springboot.base.configuration.ConfigTest1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

//@Component("") //指定扫描包
//@SpringBootApplication(scanBasePackages = "") //指定基础扫描包
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        ConfigTest1 configTest1 =(ConfigTest1) run.getBean("configTest1");
    }

}
