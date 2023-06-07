package com.atguigu.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
public interface WeatherInterface {

    //@GetExchange 声明式HTTP Interfaces调用
    //url指定你要调用的接口，accept指定接收的类型。
    //base = https://getweather.market.alicloudapi.com/
    //接收类型accept
    @GetExchange(url = "https://getweather.market.alicloudapi.com/lundear/weather1d",
            accept = "application/json")
    //注意这里的@RequestParam("areaCn") 在service下的@GetExchange下就和原来的Controller不一样了
    //这里表示的是我要发出去的参数名是areaCn
    Mono<String> getWeather(@RequestParam("areaCn") String city); //根据城市查天气
}
