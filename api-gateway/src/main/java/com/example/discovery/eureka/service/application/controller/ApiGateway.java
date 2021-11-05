package com.example.discovery.eureka.service.application.controller;


import com.example.discovery.eureka.service.application.model.GreetingResponse;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;


//@Controller
public class ApiGateway {
/**
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

    @RequestMapping(value = "/{service}/{uri}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody  GreetingResponse welcome(Model model, @PathVariable String service, @PathVariable String uri){
        System.out.println(service + "  " + uri);
        InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka(service,false);
        String baseUrl = nextServerFromEureka.getHomePageUrl();

        return restTemplate.getForObject(baseUrl+uri, GreetingResponse.class);

    }*/

}
