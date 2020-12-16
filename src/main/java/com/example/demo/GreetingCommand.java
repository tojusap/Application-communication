package com.example.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * description: GreetingCommand
 * date: 12/16/20 11:11 PM
 * author: fourwood
 */
public class GreetingCommand extends HystrixCommand<Object> {

    private RestTemplate restTemplate;
    private String url;
    private String name;

    public GreetingCommand(RestTemplate restTemplate, String url, String name){
        super(HystrixCommandGroupKey.Factory.asKey("GreetingGroup"));
        this.restTemplate = restTemplate;
        this.url = url;
        this.name = name;
    }

    @Override
    protected Object run() {
        try{
            String tem_url = url + "greeting?name=" + name;
            System.out.println(tem_url);
            ResponseEntity<Object> response = restTemplate.getForEntity(tem_url, Object.class);
            return response.getBody();
        }catch(HttpStatusCodeException error) {
            System.out.println(error.getStatusCode().toString() + ": " + error.getMessage());
            throw error;
        }
    }
}
