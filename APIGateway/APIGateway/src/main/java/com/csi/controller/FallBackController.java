package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/customerfallback")
    public String customerFallBack(){
        return "Customer Service is down please wait!!!!!";
    }
    @GetMapping("/orderfallback")
    public String orderFallBack(){
        return "Order Service is down please wait!!!!!";
    }

    @GetMapping("/productfallback")
    public String productFallBack(){
        return "Product Service is down please wait!!!!!";
    }

}
