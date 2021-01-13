package com.example.springboot.base.configurationproperties;

import com.example.springboot.SpringbootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigPropertyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        //因为Config里面加了注解@EnableConfigurationProperties(ConfigTest4.class)，而注入的类名就是这个。。。
        ConfigTest4 configTest4 = (ConfigTest4)run.getBean("config.test-com.example.springboot.base.configurationproperties.ConfigTest4");
        System.out.println(configTest4.toString());
        ConfigTest5 configTest5 = (ConfigTest5)run.getBean("configTest5");
        System.out.println(configTest5.toString());
    }
}
