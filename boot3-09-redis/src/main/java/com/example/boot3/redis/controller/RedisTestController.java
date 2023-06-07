package com.example.boot3.redis.controller;

import com.example.boot3.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */

@RestController
public class RedisTestController {

    @Autowired //为什么科研直接注入是因为你加载starter的时候
    //对应的自动配置类就已经把这些包注入到ioc中了
    //这个redisTemplate会自动保存到对应的redis数据库中
    StringRedisTemplate stringRedisTemplate;
    //默认的RedisTemplate<Object,Object> 会给redis保存默认的序列化机制
    //为了后来的系统兼容性，所有的序列化对象都要用json数据保存
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @GetMapping("/count")
    public String count(){
        Long hello = stringRedisTemplate.opsForValue().increment("hello");
        //redis常见的数据类型 k: v
        //k 一般是 String
        //v可以是多种类型
        //普通类型 redisTemplate.opsForValue()
        //string,redisTemplate.opsForValue()
        // list,        redisTemplate.opsForList()
        // set,        redisTemplate.opsForSet()
        // zset(有序集合)        redisTemplate.opsForZSet()
        //甚至是hash就是嵌套k: v        redisTemplate.opsForHash()
        // 地理位置信息计算 redisTemplate.opsForGeo()
        return "访问了[" + hello + "]次";
    }

    @GetMapping("/person/save")
    public String  savePerson(){
        //new Date 不写就是现在的格林威治时间
        Person p = new Person(1,"雷锋杨",18,new Date());
        //1.StringRedisTemplate只保存string
        //所以你要保存对象的话，你得实现序列化 或者 直接用对象redis模板
        redisTemplate.opsForValue().set("person",p);
        return "ok";
    }

    //其实要把你内存中的实体对象顺着网络节点传给远程服务器
    //那么实体都需要实现序列化接口。只不过redisTemplate不用那么麻烦。
    @GetMapping("/person/get")
    public Person getPerson(){
        Person person = (Person) redisTemplate.opsForValue().get("person");
        return person;
    }

}
