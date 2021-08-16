package com.zyimm.common.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zyimm
 */
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer{

    public  final List<String> exclude = List.of(
        "/hello", 
        "/error-not",
        "/test"
        );

   /**
    *  注册拦截器
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token的路由拦截器，并排除登录接口或其他可匿名访问的接口地址 (与注解拦截器无关)
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/**")
        .excludePathPatterns(exclude);
    }
    
}
