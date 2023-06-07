package com.atguigu.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * @author by KingOfTetris
 * @date 2023/6/5
 */
@JacksonXmlRootElement
@Data
public class Person {
    private Integer id;
    private String userName;
    private String email;
    private Integer age;
}
