package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.UserNotFoundException;
import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResourceJpa {

    private UserRepository userRepository;

    @Autowired
    public UserResourceJpa(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping(path="/jpa/users")
    public List<UserJpa> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<UserJpa> getUserById(@PathVariable int id){
        Optional<UserJpa> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<UserJpa> entity=EntityModel.of(user.get());
        // we use entity model to wrap the response data with links , so that we won't disturb the user DTO class
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
        // we use WebMvcLinkBuilder to avoid the hard coding of URL's
        entity.add(link.withRel("All-users"));
        return entity;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<UserJpa> createUser(@Valid @RequestBody UserJpa user){
        UserJpa createdUser = userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

}
