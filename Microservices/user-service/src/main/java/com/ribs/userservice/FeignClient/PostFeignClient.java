package com.ribs.userservice.FeignClient;

import com.ribs.postservice.Model.Posts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="post-service")
public interface PostFeignClient {
    @GetMapping("/post/{postId}")
    public Posts getPosts(@PathVariable String postId);


}
