package com.api.poc.Controller;

import com.api.poc.Service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendNotification")
public class SendNotification {

    private final NotificationService notificationService;

    public SendNotification(@Qualifier("SmsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/sms")
    public void call(@RequestParam String msg) {
        notificationService.sendNotification(msg);
    }
}
