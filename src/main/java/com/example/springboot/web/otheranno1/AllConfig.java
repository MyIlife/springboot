package com.example.springboot.web.otheranno1;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
public class AllConfig {
    @Bean
    public ServletRegistrationBean myServlet1(){
        MyServlet1 myServlet1 = new MyServlet1();
        return new ServletRegistrationBean(myServlet1,"/my1");
    }
    @Bean
    public FilterRegistrationBean myFilter1(){
        MyFilter1 myFilter1 = new MyFilter1();

        return new FilterRegistrationBean(myFilter1,myServlet1());
    }
}
