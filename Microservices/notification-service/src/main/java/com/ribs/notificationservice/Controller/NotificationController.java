package com.ribs.notificationservice.Controller;

import com.ribs.notificationservice.Model.Notifications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@Slf4j
public class NotificationController {

    @GetMapping("/{notificationId}")
    public Notifications getNotifications(@PathVariable String notificationId){
        log.info("Request received from the caller service:" + notificationId);
        Notifications notificationOne = new Notifications(notificationId,"Notification Details" + notificationId);
        return notificationOne;
    }
}
