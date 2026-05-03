package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name="user_details")   // here User is a keyword in H2 database ,so renamed the entity name
public class UserJpa {

    @Id   // acts as a primary key in user_details table
    @GeneratedValue  // automatically a new id is generated when a record is added to the user_details table
    private Integer id;

    @Size(min=2, message="name should be alteast of size 2")
//    @JsonProperty("User_name") , remember this JsonProperty works both for object -> Json and Json -> Object
    private String name;

    @Past(message="date should be of past")
//    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public UserJpa(){

    }

    public UserJpa(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
