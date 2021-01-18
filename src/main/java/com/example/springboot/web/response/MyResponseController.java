package com.example.springboot.web.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认在spring-boot-starter-web中引用了spring-boot-starter-json
 * 1.返回值解析器
 *  ModelAndView
 *  Model
 *  View
 *  ViewMethodReturnValue
 *  ResponseEntity
 *  ResponseBodyEmitter
 *  StreamingResponseBody
 *  HttpEntity
 *  HttpHeader
 *  Callable
 *  DeferredResult
 *  ListenableFuture
 *  CompletionStage
 *  WebAsyncTask
 * 有@ModelAttribute
 * 有@ResponseBody
 * 2.@ResponseBody 利用消息转换器MessageConverters转换json
 *  1）、内容协商：浏览器通过请求头Accept告诉服务器我需要什么样的数据格式类型
 *  2）、服务器获取浏览器传递的Accept，根据自己能力生成对应的数据格式类型并进行匹配【如果浏览器请求为xml，那么也会解析为xml返回】
 *  3）、遍历所有的消息转换器看哪个能实现步骤2
 */
@RestController
public class MyResponseController {
    @GetMapping("/getPerson")
    public Person getPerson(){
        Person p = new Person();
        p.setName("我是个person");
        return p;
    }
}
