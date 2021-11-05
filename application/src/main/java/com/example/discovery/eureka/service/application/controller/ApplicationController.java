package com.example.discovery.eureka.service.application.controller;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ApplicationController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EurekaClient eurekaClient;


    @Autowired
    private DiscoveryClient discoveryClient;



    public String getOperator() {
        String accountServiceUrl = discoveryClient.getInstances("account-service").get(0).getUri().toString();
      InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("ACCOUNT-SERVICE",false);
       String baseUrl = nextServerFromEureka.getHomePageUrl();//http://localhost:port

        return restTemplate.getForObject(baseUrl+"location", String.class);

        //return restTemplate.getForEntity("http://account-service/greeting", String.class).getBody();
    }
    @RequestMapping("/")
    public String welcome(Model model){
        List<String> results = new ArrayList<>();
        for (int i =0; i< 1000; i++){
            results.add(this.getOperator());
        }
        model.addAttribute("greeting", results);

        return "index";
    }

}
