package com.project.webservices.restfulservice.SocialMediaApp.Dao;

import com.project.webservices.restfulservice.SocialMediaApp.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // jpa/hibernate with Database

    private static List<User> allUsers=new ArrayList<>();

    private static Integer count=0;

    static {
        allUsers.add(new User(++count,"Balashiva", LocalDate.now().minusYears(26)));
        allUsers.add(new User(++count,"srinath", LocalDate.now().minusYears(25)));
        allUsers.add(new User(++count,"somesh", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return allUsers;
    }

    public User findOne(Integer id) {
        return allUsers.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++count);
        allUsers.add(user);
        return user;
    }

    public void deleteUserById(Integer id) {
        Predicate<? super User> predicate= user -> user.getId().equals(id);
        allUsers.removeIf(predicate);
    }
}
