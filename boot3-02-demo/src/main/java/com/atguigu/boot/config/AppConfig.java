package com.atguigu.boot.config;

import com.alibaba.druid.FastsqlException;
import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author by KingOfTetris
 * @date 2023/6/4
 */

//@Import(FastsqlException.class)  //第三方组件可以通过@Import导入，这样导入给IoC容器的Bean默认名字是全类名

/**
 * @EnableConfigurationProperties(Sheep.class)的功能
 * 1.开启Sheep组件的属性绑定
 * 2.默认将组件注入到IoC容器中
 */
@EnableConfigurationProperties({Sheep.class, Person.class}) //这个一般是用于导入第三方写好的组件进行属性绑定
//因为SpringBoot默认只扫描自己主程序所在的包及其子包，
//如果导入第三方包，即使组件标注了@Component,@ConfigurationProperties也注入不了，更别提属性绑定
@Configuration //标注这是个配置类
//@SpringBootConfiguration //也可以用这个注解代替 除了名字不同，用于区分，功能没有区别
public class AppConfig {

    @Bean("user00") //bean标签的作用是把返回值自动注入到ioc容器中进行管理
    // 你不写value默认就是bean的名字就是方法名user01
    //写上了以后就是user00
    //@Bean默认作用域是单例 你可以通过@Scope修改为多实例prototype 和以前xml一样
    @Scope("prototype")
    public User user01(){
        User user = new User(1,"张三");
        return user;
    }

    @Bean("pig01")
    @ConfigurationProperties(prefix = "pig") //声明这个组件的属性和配置文件中以为pig开头的属性进行绑定
    public Pig pig00(){
        return new Pig();//你看起来好像是个空pig，其实被@ConfigurationProperties(prefix = "pig")
        //配置以后它进行了属性绑定就有值了
    }
   /* @Bean
    public FastsqlException fast(){
        return new FastsqlException();
    }*/

}
