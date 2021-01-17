package com.example.springboot.web.exception;

import com.example.springboot.web.springmvc.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NullPointerException.class})
    public Response<String> nullPointException(Exception e){
        Response<String> response = new Response<>();
        response.setCode(1);
        response.setMessge("空指针异常");
        System.out.println("空指针异常：{}");
        return response;
    }
    @ExceptionHandler(Exception.class)
    public Response<String> otherException(Exception e){
        Response<String> response = new Response<>();
        response.setCode(1);
        response.setMessge("系统服务异常");
        System.out.println("系统服务异常：{}");
        return response;
    }
}
