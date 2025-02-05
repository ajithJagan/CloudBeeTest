package com.api.poc.Service.Impl;

import com.api.poc.Service.NotificationService;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.NotationDeclaration;

@Service("SmsNotification")
public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String msg) {
        System.out.println("Notification from Sms" + msg);
    }
}
