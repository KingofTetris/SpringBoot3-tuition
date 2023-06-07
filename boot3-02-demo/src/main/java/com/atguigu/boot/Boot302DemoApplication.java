package com.atguigu.boot;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//SpringBoot有默认规则，只扫描@SpringBootApplication标注的主程序所在的包boot及其子包下的程序
//所以你的demo1 把controller放在com包下 SpringBoot读不包就出错了
//当然你硬要把controller,service,dao写在外面 你只需要和以前一样自定义扫描路径就行了
//@SpringBootApplication(scanBasePackages = "com.atguigu")
//但是SpringBoot的一大特性就是约定大于特性，你最好就遵守它的特性不要去改。
@SpringBootApplication
//@SpringBootApplication相当于下面这三个注解
/*@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu")*/
public class Boot302DemoApplication {
    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
       /* String[] users = ioc.getBeanNamesForType(User.class);
        for (String user : users) {
            System.out.println(user);
        }
        Object user2 = ioc.getBean("user00");
        Object user1 = ioc.getBean("user00");
        System.out.println(user1 == user2);

        FastsqlException bean = ioc.getBean(FastsqlException.class);
        System.out.println(bean);//默认是全类名com.alibaba.druid.FastsqlException*/

    /*    String[] cats = ioc.getBeanNamesForType(Cat.class);
        String[] dogs = ioc.getBeanNamesForType(Dog.class);
        for (String cat : cats) {
            System.out.println(cat);
        }
        for (String dog : dogs) {
            System.out.println(dog);
        }*/
     /*   Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);

        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println(sheep);*/
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}
