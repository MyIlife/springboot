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
        CPTest1 CPTest1 = (CPTest1)run.getBean("config.test-com.example.springboot.base.configurationproperties.CPTest1");
        System.out.println(CPTest1.toString());
        CPTest2 CPTest2 = (CPTest2)run.getBean("cPTest2");
        System.out.println(CPTest2.toString());
        Object bean = run.getBean("org.springframework.boot.autoconfigure.AutoConfigurationPackages");
        run.close();
    }
}
