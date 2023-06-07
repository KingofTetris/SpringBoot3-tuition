/*
package com.atguigu.boot3.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * @author by KingOfTetris
 * @date 2023/6/6
 *//*

@Service
public class WeatherService {
    @Autowired
    WeatherInterface weatherInterface;
    public Mono<String> weather(String city){
        Mono<String> weather = weatherInterface.getWeather(city);
        return weather;
    }

    //1.方案1 getByWebClient 不够通用。当你api数量大的时候很麻烦
    //        Mono<String> mono = getByWebClient(city);
    private Mono<String> getByWebClient(String city,@Value(${aliyun.api} String auth)) {
        //远程调用阿里云API
        //API和SDK的区别
        //API(Application Programming Interfaces)应用编程接口
        //这个接口和你的系统可能不在一个服务器上运行，你就需要远程请求这个API
        //请求要按照别人的要求
        //SDK(Software Development Kit)软件开发工具包
        //这个工具包就是本地提供的，你按照对应的要求直接调用就可以了
        */
/**
         *
            API接口:http(s)://getweather.market.alicloudapi.com/lundear/weather1d
            返回格式:json
            请求:get
         APPCODE:0740bfd9a07a4e2d9a41d68a73549e91
         *//*

        //1.创建API对应的WebClient 网页服务端
        String api = "https://getweather.market.alicloudapi.com/lundear/weather1d";
        WebClient client = WebClient
                .create(api);
        //2.准备请求参数和API验证码
        Map<String,String> params = new HashMap<>();
        params.put("areaCn", city);
        //3.定义发请求的行为
        //响应式编程Mono
        Mono<String> mono = client.get()
                .uri(api + "?areaCn={areaCn}", params)//{}会从map里面去取对应的参数
                .accept(MediaType.APPLICATION_JSON) //定义API响应的内容格式
                .header("Authorization",
                        "APPCODE "+ auth)//header一般会要求你传个认证码
                .retrieve() //执行api
                .bodyToMono(String.class);
        return mono;
    }
}
*/
