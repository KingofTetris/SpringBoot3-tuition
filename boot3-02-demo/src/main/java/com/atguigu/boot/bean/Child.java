package com.atguigu.boot.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */

@Data
public class Child {
    private String name;
    private Integer age;
    private Date birthDay;
    private List<String> text; //数组
}
