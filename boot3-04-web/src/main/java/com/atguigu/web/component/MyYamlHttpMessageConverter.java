package com.atguigu.web.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author by KingOfTetris
 * @date 2023/6/5
 */
//后面的泛型代表支持把哪种类型转为yaml
    //这里就代表全部都可以
public class MyYamlHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private ObjectMapper objectMapper = null;//ObjectMapper的作用是把对象转成YAML

    public MyYamlHttpMessageConverter(){
        //媒体类型MediaType，大类型是文本text
        //super告诉SpringBoot这个MessageConverter支持哪种类型
        super(new MediaType("text", "yaml", Charset.forName("UTF-8")));
        //jackson-dataformat-yaml提供的YAML工厂
        //下面这段话是让它默认输出的格式去掉--- 文档缩写符
        YAMLFactory factory = new YAMLFactory().
                disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        objectMapper = new ObjectMapper(factory);
    }
    @Override
    protected boolean supports(Class<?> clazz) {
        //只要是对象类型都可以，不是基本类型
        return true;//return true就是都可以
    }

    @Override //处理请求的数据 @RequestBody 怎么读成指定的格式
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override//处理返回的数据 @ResponseBody 怎么写成指定的格式
    //methodReturnValue方法返回值写成YAML
    //后面的outputMessage你可以自定义要返回给谁，这里是服务器端口所以用HttpOutputMessage
    //你也可以返回给数据库
    protected void writeInternal(Object methodReturnValue, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
       /* OutputStream body = outputMessage.getBody();
        try{
            this.objectMapper.writeValue(body,methodReturnValue);
        }finally {
            body.close();
        }*/
        //上面是老写法，自己手动关闭流

        //try-with写法，自动关流
        try(OutputStream outputStream = outputMessage.getBody()){
            this.objectMapper.writeValue(outputStream,methodReturnValue);
        }

    }
}
