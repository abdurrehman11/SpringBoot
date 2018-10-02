package com.infotech.SpringBootServletFilter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter
            (ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("\nFiltering Request before going to Controller");

        // Multiple Filters can be applied
        // This method points to next filter (redirect request to the next filter)
        filterChain.doFilter(request, response);
        System.out.println("Filtering Request before going to Client");
    }

    @Override
    public void destroy() {

    }
}
