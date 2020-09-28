package cn.edu.scu.upload.config;
 

import cn.edu.scu.upload.listener.CustomMultipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
 
@Configuration
public class BeanConfig {
 
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver()
    {
        return new CustomMultipartResolver();
    }
}