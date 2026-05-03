package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name="Post")
public class PostJpa {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;

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
                '}';
    }
}
