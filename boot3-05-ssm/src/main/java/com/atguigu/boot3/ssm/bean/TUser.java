package com.atguigu.boot3.ssm.bean;

import lombok.Data;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
@Data
public class TUser {
    private Long id;

    private String loginName;

    private String nickName;

    private String passwd;
}
