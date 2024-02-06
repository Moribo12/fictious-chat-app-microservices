package com.ribs.apigateway.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack(){
        return "The User-Service is currently down!";
    }

    @GetMapping("/postServiceFallBack")
    public String postServiceFallBack(){
        return "The Post-Service is currently down!";
    }

    @GetMapping("/notificationServiceFallBack")
    public String notificationServiceFallBack(){
        return "The Notification-Service is currently down!";
    }
}
