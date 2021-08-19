package com.spring.project.blog.service;

import com.spring.project.blog.model.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll ();
    Post findById (Long id);
    Post save(Post post);
}
