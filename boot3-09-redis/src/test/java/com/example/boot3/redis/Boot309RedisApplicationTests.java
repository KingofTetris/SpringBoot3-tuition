package com.example.boot3.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//Spring Initializr 默认也整合了单元测试
@SpringBootTest //这个注解符号是让你在测试的时候也能使用IoC中的对象
class Boot309RedisApplicationTests {

    //StringRedisTemplate K和V全部都是字符串
    @Autowired
    StringRedisTemplate redisTemplate;
    //string,redisTemplate.opsForValue()
    @Test
    void test1() {
        redisTemplate.opsForValue().set("haha", UUID.randomUUID().toString());
        System.out.println(redisTemplate.opsForValue().get("haha"));
    }
    // list,        redisTemplate.opsForList()
    @Test
    public void test2(){
        //redis的列表是双端队列，所以插入弹出分左右
        String listName = "listtest";//要放的队列名
        //因为这个template是StringRedisTemplate 所以k,v都是String
        redisTemplate.opsForList().leftPush(listName,"张三");
        redisTemplate.opsForList().leftPush(listName,"2");
        redisTemplate.opsForList().leftPush(listName,"3");
        //前面要加上队列名
        String s = redisTemplate.opsForList().leftPop(listName);
        Assertions.assertEquals("3",s);
    }
    // set,        redisTemplate.opsForSet()
    @Test
    public void test3(){
        //redis都要记得先给变量名
        String setName = "setTest";
        redisTemplate.opsForSet().add(setName,"1","2","3","3","5");
        Boolean member1 = redisTemplate.opsForSet().isMember(setName, "5");
        Boolean member2 = redisTemplate.opsForSet().isMember(setName, "6");
        Assertions.assertTrue(member1);
//        Assertions.assertTrue(member2);
    }
    // zset(有序集合)        redisTemplate.opsForZSet()
    @Test
    public void test4(){
        //所以你可以靠这个东西做个排行榜
        String zsetName = "zsetTest";//前面是value 后面是排序依据
        redisTemplate.opsForZSet().add(zsetName,"张三",90.00);
        redisTemplate.opsForZSet().add(zsetName,"里斯",9.00);
        redisTemplate.opsForZSet().add(zsetName,"王五",9123.00);
        redisTemplate.opsForZSet().add(zsetName,"赵六",3.00);
        ZSetOperations.TypedTuple<String> popMax = redisTemplate.opsForZSet().popMax(zsetName);
        System.out.println(popMax);
    }
    //甚至是hash就是嵌套k: v        redisTemplate.opsForHash()
    @Test
    public void test5(){
        String mapName = "amap";
        redisTemplate.opsForHash().put(mapName,"name","张三");
        redisTemplate.opsForHash().put(mapName,"age","18");
    }


}
