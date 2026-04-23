package com.project.webservices.restfulservice.SocialMediaApp;

import com.project.webservices.restfulservice.SocialMediaApp.Dao.UserDaoService;
import com.project.webservices.restfulservice.SocialMediaApp.ExceptionHandlers.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUserById(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id: "+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
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
