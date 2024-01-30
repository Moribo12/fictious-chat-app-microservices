package com.ribs.userservice.controller;
;
import com.ribs.notificationservice.Model.Notifications;
import com.ribs.postservice.Model.Posts;
import com.ribs.userservice.FeignClient.NotificationFeignClient;
import com.ribs.userservice.FeignClient.PostFeignClient;
import com.ribs.userservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
     PostFeignClient postFeignClient;
    @Autowired
    NotificationFeignClient notificationFeignClient;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        User userOne = new User(userId,"User name" +userId,"xxxxx" +userId);

        Posts posts = postFeignClient.getPosts(userId);
        userOne.setPosts(posts);

        Notifications notifications = notificationFeignClient.getNotifications(userId);
        userOne.setNotifications(notifications);

        return  userOne;
    }
}
