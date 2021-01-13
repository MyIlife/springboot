package com.example.springboot.base.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 如果是true，那么外部通过MyConfiguration调用@Bean注解的方法返回的组件是先从容器中
 * 寻找，没有的话则创建加入返回（单实例bean）
 * 如果是false，那么外部通过MyConfiguration调用@Bean注解的方法不会从容器中寻找，而是相当于
 * 普通调用
 * 默认true
 *     full（true）：@Bean之间有依赖关系，则推荐使用
 *     lite（false）：无依赖的话用lite，加速容器启动
 */
@Configuration(proxyBeanMethods = true)
@ImportResource("classpath:bean.xml")
@ComponentScan("com.example.springboot.base.configuration")
public class MyConfiguration {
    @Bean
    public ConfigTest1 configTest1(){
        ConfigTest1 configTest1 = new ConfigTest1();
        configTest1.setAge(213);
        configTest1.setName("test");
        configTest1.setConfigTest2(configTest2());
        return configTest1;
    }
    @Bean
    public ConfigTest2 configTest2(){
        ConfigTest2 configTest2 = new ConfigTest2();
        configTest2.setName("我是2");
        configTest2.setAge(232);
        return configTest2;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(MyConfiguration.class);
        String[] beanDefinitionNames = a.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanDefinitionName = beanDefinitionNames[i];
            System.out.println(beanDefinitionName);
        }
        MyConfiguration m = (MyConfiguration)a.getBean("myConfiguration");
        System.out.println(m.configTest1()==a.getBean("configTest1"));
        System.out.println(m.configTest1().getConfigTest2()==a.getBean("configTest2"));
    }
}
