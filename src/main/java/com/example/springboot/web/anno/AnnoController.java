package com.example.springboot.web.anno;

import com.example.springboot.web.springmvc.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 注解的使用：
 * @PathVariable 路径变量
 * @RequestHeader 获取请求头信息
 * @RuquestParam 请求参数【表单提交，json提交会报错，无法转换】
 * @CookieValue 获取cookies
 * @RequestBody 请求体【用于json】
 * @RequestAttribute 请求域中的属性获取【因为跳转类型的操作不能用@RestController注解，所以看SkipController】
 * @MatixVariable 矩阵变量【配合路径变量使用，如果要开启的话需要在配置中手动开启】
 */



@RestController
public class AnnoController {
    /**
     * PathVariable
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User testPathParam1(@PathVariable("id") Integer id){
        User u = new User();
        u.setId(id);
        return u;
    }
    @GetMapping("/user/{name}/{age}")
    public User testPathParam2(@PathVariable("name") String name,@PathVariable("age") int age){
        User u = new User();
        u.setName(name);
        u.setAge(age);
        return u;
    }

    @PostMapping("/user/save/{age}/{name}")
    public String testPathParam3(@PathVariable Map<String,String> map){
        User u = new User();
        u.setAge(Integer.valueOf(map.get("age")));
        u.setName(map.get("name"));
        return u.toString();
    }

    /**
     * @RequestHeader
     * @param mp
     * @return
     */
    @GetMapping("/getHeaders")
    public Map<String,String> getHeaders(@RequestHeader Map<String,String> mp){
        return mp;
    }

    /**
     * @RequestParam
     * @param id
     * @param list
     * @param mp
     */
    @PostMapping("/paramTest")
    public void getParam(@RequestParam("id") Integer id, @RequestParam("list") List<String> list, @RequestParam Map<String,String> mp){
        System.out.println("输出id");
        System.out.println(id);
        System.out.println("输出list");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("输出map");
        Iterator<String> iterator = mp.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next+":"+mp.get(next));
        }
    }
    @PostMapping("/body")
    /**
     * @RequestBody
     */
    public Object testRequestBody(@RequestBody String body){
        return body;
    }

}
