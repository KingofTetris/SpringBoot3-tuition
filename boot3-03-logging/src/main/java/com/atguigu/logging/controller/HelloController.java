package com.atguigu.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */
@Slf4j //因为SpringBoot底层实现日志的实现类是Log4j，你打上这个注解都不用获取logger了，会自动给你注入一个log对象
@RestController
public class HelloController {
    @GetMapping("/h")
    public String hello(String a,String b){
        log.trace("trance 日志...");
        log.debug("debug日志,,,");
//        #SpringBoot默认日志级别是info
        //参数同名自动绑定
        log.info("info日子...参数a:{} b:{}",a,b);//日志特有的占位符格式，你要用+号连接当然也可以
        log.warn("warn日志。。。");
        log.error("error日志...");
        log.info("哈哈哈哈，我进来了");
        return "hello";
    }
}
