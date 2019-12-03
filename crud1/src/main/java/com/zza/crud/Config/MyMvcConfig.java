package com.zza.crud.Config;

import com.zza.crud.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {       //添加视图映射
        registry.addViewController("/").setViewName("Login");
        registry.addViewController("/index.html").setViewName("Login");
        registry.addViewController("/main.html").setViewName("success");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/user/register","/","/static/**","/webjars/**","/user/login","/user/register.html");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
