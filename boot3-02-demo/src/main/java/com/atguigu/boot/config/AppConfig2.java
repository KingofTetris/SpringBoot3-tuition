package com.atguigu.boot.config;

import com.atguigu.boot.bean.Cat;
import com.atguigu.boot.bean.Dog;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */
//@ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
// 如果你放在类上，如果注解有效，整个类才会进行配置
@Configuration
public class AppConfig2 {
    //下面演示条件注解
    //如果系统中存在组件com.alibaba.druid.FastsqlException就注入一个Cat给IoC
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    @Bean
    public Cat cat01(){
        return new Cat();
    }
    //如果不存在注入一个Dog
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    @Bean
    public Dog dog01(){
        return new Dog();
    }

    //如果存在一个dog01就注入一个叫张三的User
    @ConditionalOnBean(name = "dog01")
    @Bean
    public User user1(){
        return new User(1,"张三");
    }
    //如果不存在一个dog01就注入一个叫李四的User
    @ConditionalOnMissingBean(name = "dog01")
    @Bean
    public User user2(){
        return new User(2,"里斯");
    }
}
