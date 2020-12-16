package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
    public Object test(@RequestParam(value = "name", defaultValue = "World") String name) throws ExecutionException, InterruptedException {
        Future<Object> fs = new GreetingCommand(restTemplate, url, name).queue();
        return fs.get();
    }

}
