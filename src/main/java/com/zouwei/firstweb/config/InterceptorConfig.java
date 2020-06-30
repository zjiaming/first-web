package com.zouwei.firstweb.config;

import com.zouwei.firstweb.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * 不用权限访问的 /api/v1/pub/
 * 要用权限访问的 /api/v1/pri/
 * <p>
 * 添加 Configuration 注解，才能被扫描到
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(loginInterceptor())
//                //添加需要被拦截的路径， api前面的斜杆不要忘记了
//                .addPathPatterns("/api/v1/pri/*/*/**")
//                //登录和注册不需要被拦截，需要被放行
//                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");
//
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
