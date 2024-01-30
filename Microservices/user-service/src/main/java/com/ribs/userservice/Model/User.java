package com.ribs.userservice.Model;

import com.ribs.notificationservice.Model.Notifications;
import com.ribs.postservice.Model.Posts;
import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userPhoneNumber;
    private Posts posts;
    private Notifications notifications;

    public User(String userId, String userName, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }
}


