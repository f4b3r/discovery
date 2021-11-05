package com.example.discovery.eureka.service.account.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;



    @Value("${server.port:no port}")
    private String port;

    @RequestMapping("/greeting")
    public String sayHello(){
        return String.format("Hello from  '%s'! ",eurekaClient.getApplication(appName).getName());
    }

    @RequestMapping("/location")
    public String printLocation(){
        return String.format("Hello from  '%s'!  ",eurekaClient.getApplication(appName).getInstances().get(0).getHomePageUrl());
    }
}
