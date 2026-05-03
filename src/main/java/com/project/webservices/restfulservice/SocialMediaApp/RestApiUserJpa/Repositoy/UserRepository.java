package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy;

import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpa,Integer> {
}
