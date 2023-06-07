package com.example.boot3.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private Date birthDay;
}
