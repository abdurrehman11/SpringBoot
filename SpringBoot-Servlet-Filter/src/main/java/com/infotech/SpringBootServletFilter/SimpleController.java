package com.infotech.SpringBootServletFilter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController{

    @RequestMapping(value = "/filter")
    public String filterRequest() {

        System.out.println("Entered into Controller");
        return "Request Filtered";
    }
}
