package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: demo
 * @description:
 * @author: FENG CHEN
 * @create: 2021-07-04 12:04
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api",c->true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/**")    //拦截所有的接口
        .excludePathPatterns("/api/user/login")
        .excludePathPatterns("/api/user/reg")
        .excludePathPatterns("/login.html")
        .excludePathPatterns("/reg.html")
        .excludePathPatterns("/**/*.css")
        .excludePathPatterns("/**/*.js")
        .excludePathPatterns("/**/*.png")
        .excludePathPatterns("/**/*.jpg");
    }
}
