package com.api.poc.Service.Impl;

import com.api.poc.Service.NotificationService;
import org.springframework.stereotype.Service;

@Service("EmailNotification")
public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String msg) {
        System.out.println("Message from email " + msg);
    }
}
