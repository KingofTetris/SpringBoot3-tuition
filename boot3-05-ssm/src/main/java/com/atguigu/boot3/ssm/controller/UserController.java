package com.atguigu.boot3.ssm.controller;

import com.atguigu.boot3.ssm.bean.TUser;
import com.atguigu.boot3.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;//这里报错的原因是idea不知道mapper是Spring中的组件，可以被动态代理类实现。
    // 所以它会觉得你没有实现这个接口，直接报错。
    // Could not autowire. No beans of 'UserMapper' type found.
    //不影响运行，但是如果你强迫症可以在Setting里面修改，但建议不要改。

    @GetMapping("/user/{id}") //虽然你的路径参数名和形参名一致就会自动绑定，还是建议你加上@PathVariable
    public TUser getUser(/*@PathVariable("id")*/ Long id){
        return userMapper.getUserById(1);
    }
}
