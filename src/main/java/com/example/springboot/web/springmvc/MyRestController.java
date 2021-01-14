package com.example.springboot.web.springmvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController {
    @GetMapping("/user")
    public User getUser(){
        User user = new User();
        user.setAge(23);
        user.setName("小明");
        return user;
    }
    @DeleteMapping("/user")
    public String deleteUser(int id){
        return "delete";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "put user";
    }
}
