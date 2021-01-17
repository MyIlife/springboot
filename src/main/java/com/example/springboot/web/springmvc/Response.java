package com.example.springboot.web.springmvc;

import lombok.Data;

@Data
public class Response<T> {
    private Integer code = 0;
    private String messge;
    private T data;
}
