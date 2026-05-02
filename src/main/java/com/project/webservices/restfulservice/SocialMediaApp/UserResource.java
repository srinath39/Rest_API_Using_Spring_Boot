package com.project.webservices.restfulservice.SocialMediaApp;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.project.webservices.restfulservice.SocialMediaApp.Dao.UserDaoService;
import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    @Autowired
    public UserResource(UserDaoService userDaoService){
        this.userDaoService=userDaoService;
    }

    @GetMapping(path="/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entity=EntityModel.of(user);
        // we use entity model to wrap the response data with links , so that we won't disturb the user DTO class
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
        // we use WebMvcLinkBuilder to avoid the hard coding of URL's
        entity.add(link.withRel("All-users"));
        return entity;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User createdUser = userDaoService.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteUserById(id);
    }

}
