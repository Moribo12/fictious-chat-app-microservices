package com.ribs.postservice.Controller;

import com.ribs.postservice.Model.Posts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@Slf4j
public class PostController {

    @GetMapping("/{postId}")
    public Posts getPosts(@PathVariable String postId){
        log.info("Request received:" + postId);
        Posts postOne = new Posts(postId,"Post Description for" + postId);

        return postOne;
    }
}
