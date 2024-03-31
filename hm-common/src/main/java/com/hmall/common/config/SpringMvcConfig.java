package com.hmall.common.config;


import com.hmall.common.interceptors.UserInfoInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//使用DispatcherServlet作为条件，购物车服务中有springmvc就有DispatcherServlet条件，
//网关微服务没有springmvc就没有DispatcherServlet api,此配置不生效
@ConditionalOnClass(DispatcherServlet.class)//只在微服务生效不在网关生效
public class SpringMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInfoInterceptor());
    }
}
