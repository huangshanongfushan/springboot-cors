package com.duplicall.configure;/**
 * Created by limeng on 2017/9/29.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author mli
 * @description
 * @create 2017-09-29 8:32
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 跨域放开
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

}
