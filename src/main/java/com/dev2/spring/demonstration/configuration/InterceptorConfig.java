package com.dev2.spring.demonstration.configuration;

import com.dev2.spring.demonstration.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterceptorConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor("\n\nESSE É UM EXEMPLO DE INTERCEPTADOR DE REQUISIÇÃO");
    }
}
