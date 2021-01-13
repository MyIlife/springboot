package com.example.springboot.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * 等同于
 * @Controller
 * @ResponseBody
 */
@RestController
public class MyController {
    @GetMapping(value = "/getUser"/*,produces = "application/json; charset=utf-8"*/)
    public MyClass getUser(){
        MyClass m = new MyClass();
        m.setName("李豪");
        m.setAge(28);
        m.setSex("男");
        return m;
    }
    @RequestMapping("/hello")
    public String getHello(){
        return "你好";
    }
}
