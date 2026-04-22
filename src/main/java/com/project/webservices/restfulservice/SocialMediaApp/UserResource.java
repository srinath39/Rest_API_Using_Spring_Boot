package com.project.webservices.restfulservice.SocialMediaApp;

import com.project.webservices.restfulservice.SocialMediaApp.Dao.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        userDaoService.save(user);
        return ResponseEntity.created(null).build();
    }

}
