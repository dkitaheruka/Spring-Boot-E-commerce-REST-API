package com.getfocused.ecomerceRESTAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return"Thank you for choosing this ecomerce where every price are afordable";
    }
}
