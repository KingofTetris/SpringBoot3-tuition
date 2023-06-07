package com.atguigu.boot3.ssm.mapper;

import com.atguigu.boot3.ssm.bean.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
public interface UserMapper {

    /**
     * mapper里面的方法有几百种方法，这里规定一种标准的写法
     *
     * 1.每个方法在Mapper文件中有一个sql标签对应
     * 2.开头以get.update,delete开头，所有形参加上@Param("xx")，然后在sql种用xx取值
     *
     * @param id
     * @return
     */
    TUser getUserById(@Param("id") long id);


















}
