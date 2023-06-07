package com.atguigu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.atguigu")
public class Boot304WebApplication {

    /**
     *
     * 1. /webjars/** 的所有路径 资源都在 classpath:/META-INF/resources/webjars/
     *
     * 2.静态资源默认访问的四个路径
     * /** 的所有路径 资源都在
     * classpath:/META-INF/resources/、
     * classpath:/resources/、
     * classpath:/static/、
     * classpath:/public/
     * 下
     *
     * 3. 所有静态资源都定义了缓存规则。【浏览器访问过一次，就会缓存一段时间】，但此功能参数无默认值
     *   通过spring.web设置
     *   a. period： 缓存间隔。 默认 0S；
     *   b. cacheControl：缓存控制。 默认无；
     *   c. useLastModified：是否使用lastModified头。 默认 false；
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Boot304WebApplication.class, args);
    }

}
