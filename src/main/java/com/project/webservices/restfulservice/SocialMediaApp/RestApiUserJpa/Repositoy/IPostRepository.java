package com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.Repositoy;

import com.project.webservices.restfulservice.SocialMediaApp.RestApiUserJpa.PostJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPostRepository extends JpaRepository<PostJpa,Integer> {
    Optional<PostJpa> findByIdAndUserId(int post_id, int user_id);
}
