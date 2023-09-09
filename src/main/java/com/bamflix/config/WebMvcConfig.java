package com.bamflix.config;

import com.bamflix.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
            .excludePathPatterns("/css/**", "/images/**", "/js/**"); // 인터셉터 호출에서 제외

        // 애플리케이션 내의 모든 페이지(URI)에 접근할 때, LoginCheckInterceptor의 preHandle( )이 작동
        registry.addInterceptor(new LoggerInterceptor()) //
            .addPathPatterns("/**/**")
            .excludePathPatterns("/log*");
    }

}
