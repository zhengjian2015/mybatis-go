package com.example.demo.service;

import com.example.demo.entities.CommonResult;
import com.example.demo.entities.LoginMsg;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    public static final String PAYMENT_URL = "http://127.0.0.1:8001/cloud-msg-service";

    public CommonResult login(LoginMsg payment) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(PAYMENT_URL +"/admin/login",payment, CommonResult.class);
    }
}
