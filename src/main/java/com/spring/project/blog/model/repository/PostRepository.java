package com.spring.project.blog.model.repository;


import com.spring.project.blog.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
