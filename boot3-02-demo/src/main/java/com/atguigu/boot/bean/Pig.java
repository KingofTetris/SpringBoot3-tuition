package com.atguigu.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */
//进行属性绑定前，要注入对象。@Component也好，直接用AppConfig的@Bean注入也好,@EnableConfigurationProperties也好。
// 总之你得先注入。
//@ConfigurationProperties(prefix = "pig") //声明这个组件的属性和配置文件中以为pig开头的属性进行绑定
    //当然你直接写到注入方法上也行。
//@Component
public class Pig {

    private Long id;

    private String name;

    private Integer age;

    public Pig(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Pig() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
