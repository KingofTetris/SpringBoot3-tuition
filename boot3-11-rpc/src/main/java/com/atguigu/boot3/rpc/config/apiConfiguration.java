package com.atguigu.boot3.rpc.config;

import com.atguigu.boot3.rpc.service.ExpressInterface;
import com.atguigu.boot3.rpc.service.WeatherInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

/**
 * 这一章RPC好好看看WebClient和HttpInterface怎么做抽取，真正的大厂项目做API调用就是这么做的。
 */

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
@Configuration
public class apiConfiguration {
    //方案2.使用HTTP interface
    //把Service代理工厂注入到IoC中，以后不管是哪个API 都用这个工厂创建
    //用@Value(${})取去配置文件中的值
    @Bean
    HttpServiceProxyFactory httpServiceProxyFactory(@Value("${aliyun.api}") String auth) {
        //1、创建API网页客户端
        //多个API共用服务代理工厂就不能把base-url写在这里了。
        //而是要写在对应的服务接口上。
        //另外WebClient是响应式Web提供的，创建SB工厂的时候要选reactive web
        WebClient client = WebClient.builder()
                .defaultHeader("Authorization", "APPCODE " + auth)
                .codecs(clientCodecConfigurer -> {
                    clientCodecConfigurer
                            .defaultCodecs()
                            .maxInMemorySize(256 * 1024 * 1024);
                    //响应数据量太大有可能会超出BufferSize，所以这里设置的大一点
                })
                .build();
        //2、通过API客户端，创建对应工厂
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
        return factory;
    }
    //现在你写httpServiceProxyFactory,
    // 就会自动调用IoC容器中的httpServiceProxyFactory工厂创建代理对象
    @Bean
    WeatherInterface weatherInterface(HttpServiceProxyFactory httpServiceProxyFactory) {
        //获取代理对象
        WeatherInterface weatherInterface = httpServiceProxyFactory
                .createClient(WeatherInterface.class);
        //返回每个api的代理对象
        return weatherInterface;
    }

    @Bean
    ExpressInterface expressInterface(HttpServiceProxyFactory httpServiceProxyFactory) {
        ExpressInterface expressInterface =
                httpServiceProxyFactory.createClient(ExpressInterface.class);
        return expressInterface;
    }
}
