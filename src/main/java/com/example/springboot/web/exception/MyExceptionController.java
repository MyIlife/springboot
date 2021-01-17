package com.example.springboot.web.exception;

import com.example.springboot.web.springmvc.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyExceptionController {
    @GetMapping("/testError")
    public Response<String> error(){
        int i = 1/0;
        return new Response<>();
    }
}
