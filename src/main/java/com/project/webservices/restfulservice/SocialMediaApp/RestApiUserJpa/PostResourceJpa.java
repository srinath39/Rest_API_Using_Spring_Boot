package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.PostNotFoundException;
import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResourceJpa {

    private IPostRepository postRepository;

    @Autowired
    public PostResourceJpa(IPostRepository postRepository){
        this.postRepository=postRepository;
    }

//    @GetMapping("/jpa/users/{user_id}/posts/{post_id}")
//    public PostJpa getPostByIdOfUser(@PathVariable int user_id ,@PathVariable int post_id){
//        return postRepository.findByIdAndUserId(post_id,user_id)
//                .orElseThrow(()->new PostNotFoundException("id: "+post_id));
//    }
}
