package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.PostNotFoundException;
import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.UserNotFoundException;
import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy.IPostRepository;
import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class PostResourceJpa {

    private IPostRepository postRepository;
    private IUserRepository userRepository;

    @Autowired
    public PostResourceJpa(IPostRepository postRepository,IUserRepository userRepository){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
    }

//    @GetMapping("/jpa/users/{user_id}/posts/{post_id}")
//    public PostJpa getPostByIdOfUser(@PathVariable int user_id ,@PathVariable int post_id){
//        return postRepository.findByIdAndUserId(post_id,user_id)
//                .orElseThrow(()->new PostNotFoundException("id: "+post_id));
//    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<PostJpa> createAPostForUser(@PathVariable int id, @Valid @RequestBody PostJpa post){
        Optional<UserJpa> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        post.setUser(user.get());
        PostJpa createdPost=postRepository.save(post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}")
                .buildAndExpand(createdPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
