package com.project.webservices.restfulservice.SocialMediaApp.Dao;

import com.project.webservices.restfulservice.SocialMediaApp.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // jpa/hibernate with Database

    private static List<User> allUsers=new ArrayList<>();

    static {
        allUsers.add(new User(1,"Balashiva", LocalDate.now().minusYears(26)));
        allUsers.add(new User(2,"srinath", LocalDate.now().minusYears(25)));
        allUsers.add(new User(3,"somesh", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return allUsers;
    }

    public User findOne(Integer id) {
        return allUsers.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    // get all users
    // get a specific user
    // create a user
    // delete a user
}
