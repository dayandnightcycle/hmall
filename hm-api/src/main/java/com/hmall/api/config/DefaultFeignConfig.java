package com.hmall.api.config;

import com.hmall.common.utils.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

//此配置类生效还需在微服务调用方启动类的@EnableFeignClients注解中配置defaultConfiguration=DefaultFeignConfig.class
public class DefaultFeignConfig {
    @Bean
    public RequestInterceptor userInfoRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userId = UserContext.getUser();
                if (userId!=null){
                    //交易服务的请求从网关来，有userId,这里把userId放到feign的请求拦截器中供服务之间调用
                    requestTemplate.header("user-info",userId.toString());
                }
            }
        };
    }
}
