package com.atguigu.web.config;

import com.atguigu.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author by KingOfTetris
 * @date 2023/6/5

 *代码方式进行配置*/
//@EnableWebMvc //这个标识会禁用boot的默认配置，小心。
@Configuration
public class MyConfig implements WebMvcConfigurer {
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //保留以前的配置
        WebMvcConfigurer.super.addResourceHandlers(registry);
        //自己写
        registry.addResourceHandler( "/static/**")
                .addResourceLocations("classpath:/a/","classpath:/b/")
                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
    }
     //或者你不实现 用@Bean返回WebMvcConfigurer也是一样的
    //原理就是容器中有一个WebMvcConfigurer组件就会生效。因为
    //底层代码有一个委托类调用了所以的WebMvcConfigurer底层配置方法
    */
    //配置一个能把对象转为yaml的HTTPMessageConvert
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //继承原来的8个转化器
        WebMvcConfigurer.super.configureMessageConverters(converters);
        //加上自定义的Converter
        converters.add(new MyYamlHttpMessageConverter());
    }

    /**
     * springMVC默认拦截静态资源
     * 解决 No mapping for GET /favicon.ico
     * @param registry
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }*/
}
