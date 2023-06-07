package com.atguigu.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by KingOfTetris
 * @date 2023/6/6
 */

@ControllerAdvice //这个类是异常处理器
public class GlobalExceptionHandler {


    //因为这个类不是Controller,不会加上@RestController
    // 你要返回信息给客户端就需要自己加上@ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseBody
    //这里的参数和HttpServletRequest request是一样的。
    //因为底层都是SpringMVC调用DispatcherServlet进行处理
    //它会自动把获取到的请求异常绑定给形成。
    //你直接用就可以了。
    public String handleException(Exception e){
        return "ohho~~网页出错了，统一处理，原因是" + e.getMessage();
    }
}
