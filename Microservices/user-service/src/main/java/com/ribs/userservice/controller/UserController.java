package com.ribs.userservice.controller;
;
import com.ribs.notificationservice.Model.Notifications;
import com.ribs.postservice.Model.Posts;
import com.ribs.userservice.FeignClient.NotificationFeignClient;
import com.ribs.userservice.FeignClient.PostFeignClient;
import com.ribs.userservice.Model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
//    public static final String USER_SERVICE ="user-service";
    @Autowired
     PostFeignClient postFeignClient;
    @Autowired
    NotificationFeignClient notificationFeignClient;

    @GetMapping("/{userId}")
    @CircuitBreaker(name="user-service",fallbackMethod = "userFallBack")
    public User getUser(@PathVariable String userId){
        User userOne = new User(userId,"User name" +userId,"xxxxx" +userId);

        Posts posts = postFeignClient.getPosts(userId);
        userOne.setPosts(posts);

        Notifications notifications = notificationFeignClient.getNotifications(userId);
        userOne.setNotifications(notifications);

        return  userOne;
    }

    //The return Type of the fallbackMethod must always be the same as the return
    //type of the api you are invoking(the one annotated with@CircuitBreaker).
    //The fallbackMethod must have the Exception as a parameter.
    public User userFallBack(Exception userException){
        return new User("1","userOne","12454");
    }
}
