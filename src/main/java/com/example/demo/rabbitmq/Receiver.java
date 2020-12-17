package com.example.demo.rabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * description: Receiver
 * date: 12/17/20 3:32 AM
 * author: fourwood
 */
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
