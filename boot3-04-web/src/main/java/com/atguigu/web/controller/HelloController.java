package com.atguigu.web.controller;

import com.atguigu.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by KingOfTetris
 * @date 2023/6/5
 */
@RestController
@Slf4j
public class HelloController {

    /**
     * ● PathPatternParser 在 jmh 基准测试下，有 6~8 倍吞吐量提升，降低 30%~40%空间分配率
     * 也就是* 最新的路径解析器比原来的效率高
     * ● PathPatternParser 兼容 AntPathMatcher语法，并支持更多类型的路径模式
     * ● PathPatternParser  "/**" 多段匹配的支持仅允许在模式末尾使用
     * 放在中间直接就报错了，你要修改回原来的就要在配置文件里面改成ant风格
     * # 改变路径匹配策略：
     * # ant_path_matcher 老版策略；
     * # path_pattern_parser 新版策略 默认
     * spring.mvc.pathmatch.matching-strategy=ant_path_matcher
     * @param request
     * @param path
     * @return
     */

    /**
     * Ant 风格的路径模式语法具有以下规则：
     * ● *：表示任意数量的字符。
     * ● ?：表示任意一个字符。
     * ● **：表示任意数量的目录。
     * ● {}：表示一个命名的模式占位符。
     * ● []：表示字符集合，例如[a-z]表示小写字母。
     * */

    //如果你路径中有**才修改回ant
    @GetMapping("/a*/b?/{p1:[a-f]+}")
    public String hello(HttpServletRequest request,
                        @PathVariable("p1") String path) {
        log.info("路径变量p1： {}", path);
        //获取请求路径
        String uri = request.getRequestURI();
        return uri;
    }

    @GetMapping("/person")
    public Person person(/*@RequestBody Person person*/){
        Person p = new Person();
        p.setId(1);
        p.setAge(22);
        p.setEmail("dasda@qq.com");
        p.setUserName("张三");
//        int i = 10/0; //模拟异常
        int[] list = new int[1];
        list[0] = 1;
        list[1] = 2;
        return p;
    }


    /**
     * 1.@ExceptionHandler 标识一个方法处理错误，默认只能处理这个类所发生的指定错误
     * 2.@ControllerAdvice 标识在一个类上表示这是一个异常处理器，所有的指定异常如果没有精确指定就都会被它处理
     * 优先级和大多数一样，有精确的就指定精确的，没有就使用统一的处理器。
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    //这里的参数和HttpServletRequest request是一样的。
    //因为底层都是SpringMVC调用DispatcherServlet进行处理
    //它会自动把获取到的请求异常绑定给形成。
    //你直接用就可以了。
    public String handleException(Exception e){
        return "ohho~~出错了，原因是" + e.getMessage();
    }

}
