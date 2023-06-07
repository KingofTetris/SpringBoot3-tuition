package com.atguigu.boot3.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.@MapperScan告诉Mybatis扫描哪个包下的Mapper
//2.告诉这个Mapper对应的映射文件在哪，如果你不配，就得保证mapper和映射文件包名一致，
// 在这里就是要在resources下建立com\atguigu\boot3\ssm\mapper比较麻烦。
//所以你直接在配置文件里面指定映射位置就行了
//@MapperScan包下的mapper都会被自动扫描创建动态实现类注入到IoC容器中
//到时候你只需要@Autowired调用就行了
@MapperScan(basePackages = "com.atguigu.boot3.ssm.mapper")
@SpringBootApplication
public class Boot305SSMApplication {
    public static void main(String[] args) {

        //1.SpringApplicationw Boot应用的入口
        SpringApplication.run(Boot305SSMApplication.class, args);

        /*//拆成两步来写就会有一些有意思的事情发生 但是其实意义不大
        //1.程序化自定义SpringApplication的参数,但是配置文件优先于程序化
        SpringApplication application = new SpringApplication(Boot305SSMApplication.class);
        //在控制台开启Banner
        //但是以为配置文件优先。
        application.setBannerMode(Banner.Mode.CONSOLE);
        application.run(args);*/
    }

}
