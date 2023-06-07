package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */
//@Controller
//@ResponseBody //给所有类的方法都加上这个注解，代表所有返回纯文本数据或者JSON而不是逻辑视图
    //@RestController就是两者的结合
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello,Spring Boot 3";
    }
}
