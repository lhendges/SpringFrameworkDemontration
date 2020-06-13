package com.dev2.spring.demonstration.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("\n\nEssa é uma demonstração de interceptadores de requisição.");
        System.out.println("A requisição interceptada possui os seguintes detalhes: ");
        System.out.println("Verbo HTTP: " + request.getMethod());
        System.out.println("URI de requisição: " + request.getRequestURI());
        return true;
    }
}
