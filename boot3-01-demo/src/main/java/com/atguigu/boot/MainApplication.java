package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author by KingOfTetris
 * @Description 启动Spring Boot的主入口程序 只能有一个 随便叫什么都行
 * @date 2023/6/4
 */
@SpringBootApplication //告诉SpringBoot 这是一个SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class);
    }
}
