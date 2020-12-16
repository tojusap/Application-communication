package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * description: ServiceCall
 * date: 12/16/20 8:58 PM
 * author: fourwood
 */
@RestController
public class ServiceCall {
    @Value("${URL}")
    String url;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Object callGreeting(){
        try{
            ResponseEntity<Object> response = restTemplate.getForEntity(url + "greeting", Object.class);
            return response.getBody();
        }catch(HttpStatusCodeException error) {
            throw error;
        }
    }
}
