package com.atguigu.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */
@RestController
public class HelloController {
    @GetMapping("/haha")
    public String hello(){
        return "Hello";
    }

  /*  @GetMapping("/incr")
    public String incr(){
        Long haha = redisTemplate.opsForValue().increment("haha");
        return "增加后的值是" + haha;
    }*/

}
