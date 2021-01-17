package com.example.springboot.web.springmvc;

import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @PostMapping("/login")
    public Response<String> login(@RequestBody User user){
        Response<String> response = new Response<>();
        return response;
    }
    @GetMapping("/index")
    public Response<String> index(@RequestBody User user){
        System.out.println("调用");
        Response<String> response = new Response<>();
        return response;
    }
}
