package com.ribs.userservice.FeignClient;

import com.ribs.notificationservice.Model.Notifications;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="notification-service")
public interface NotificationFeignClient {

    @GetMapping("/notification/{notificationId}")
    public Notifications getNotifications(@PathVariable String notificationId);
}
