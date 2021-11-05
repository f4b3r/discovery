package com.example.discovery.eureka.service.account.controller;



import java.io.Serializable;

public class GreetingResponse implements Serializable {

    public String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
