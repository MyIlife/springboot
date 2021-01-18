package com.example.springboot.web.anno;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SkipController {
    @GetMapping("/goto")
    public String gotoPage(@RequestParam String name, @RequestParam int age, HttpServletRequest request){
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        return "forward:/skip";
    }
    @ResponseBody
    @GetMapping("/skip")
    public String skip(@RequestAttribute("age") int age,
                          @RequestAttribute("name") String name,
                          HttpServletRequest request){
        Object age1 = request.getAttribute("age");
        System.out.println(age1.toString());
        System.out.println(age);
        System.out.println(name);
        return "success";
    }
}
