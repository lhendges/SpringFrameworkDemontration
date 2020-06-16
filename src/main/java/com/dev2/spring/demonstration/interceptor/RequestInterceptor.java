package com.dev2.spring.demonstration.interceptor;

import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private String message;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(message);
        System.out.println("A requisição interceptada possui os seguintes detalhes: ");
        System.out.println("Verbo HTTP: " + request.getMethod());
        System.out.println("URI de requisição: " + request.getRequestURI());
        return true;
    }
}
