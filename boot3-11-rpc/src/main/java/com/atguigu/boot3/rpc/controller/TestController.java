package com.atguigu.boot3.rpc.controller;

import com.atguigu.boot3.rpc.service.ExpressInterface;
import com.atguigu.boot3.rpc.service.WeatherInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
@RestController
public class TestController {
//    @Autowired
//    WeatherService weatherService;
    @Autowired
    WeatherInterface weatherInterface;
    @Autowired
    ExpressInterface expressInterface;
    @GetMapping("/weather")
    //@RequestParam("city") 接收请求参数名为city的值给形参city
    public Mono<String> weather(@RequestParam("city") String city){
        return weatherInterface.getWeather(city);
    }

    @GetMapping("/express")
    public Mono<String> express(@RequestParam("no") String no){
        return expressInterface.getExpress(no);
    }
}
