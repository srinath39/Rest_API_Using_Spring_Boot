package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity(name="Post")
public class PostJpa {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=5, message="Description should be alteast of size 5")
    private String description;

    public UserJpa getUser() {
        return user;
    }

    public void setUser(UserJpa user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private UserJpa user;

    public PostJpa(){

    }

    public PostJpa(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PostJpa{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
