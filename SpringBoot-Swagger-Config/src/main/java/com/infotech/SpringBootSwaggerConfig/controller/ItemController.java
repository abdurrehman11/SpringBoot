package com.infotech.SpringBootSwaggerConfig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    // Swagger Link -> http://localhost:8080/swagger-ui.html

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<String> getItems() {
        List<String> itemsList = new ArrayList<>();
        itemsList.add("Honey");
        itemsList.add("Almond");
        return itemsList;
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String createItem() {
        return "Items is saved successfully";
    }
}
