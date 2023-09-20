package com.pharmacy.config;

import com.pharmacy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 * @author Alonso
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginInterceptor());
        //所有路径拦截
        interceptor.addPathPatterns("/**")
        //不拦截的路径
        .excludePathPatterns("/login", "/userLogin");
    }
}
