package com.infotech.SpringBootInterceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

//    As a basic guideline, fine-grained handler-related preprocessing tasks are candidates for HandlerInterceptor
//    implementations, especially factored-out common handler code and authorization checks. On the other hand, a Filter
//    is well-suited for request content and view content handling, like multipart forms and GZIP compression. This typically
//    shows when one needs to map the filter to certain content types (e.g. images), or to all requests.

    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("\nPre Handle method is Calling");
        return true;
    }

    @Override
    public void postHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {

        System.out.println("Leaved the Api");
        System.out.println("Post Handle method is Calling\n");
    }

    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.println("Request and Response is completed");
    }
}
