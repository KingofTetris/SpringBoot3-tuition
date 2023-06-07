package com.atguigu.boot3.rpc.service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */
public interface ExpressInterface {
    @GetExchange(url = "https://wuliu.market.alicloudapi.com/kdi",
            accept = "application/json")
    Mono<String> getExpress(@RequestParam("no") String no);
}
