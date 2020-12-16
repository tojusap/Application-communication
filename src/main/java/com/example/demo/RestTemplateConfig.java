package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sun.misc.Contended;

/**
 * description: RestTemplateConfig
 * date: 12/16/20 9:12 PM
 * author: fourwood
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @ConditionalOnMissingBean(value=RestTemplate.class)
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
