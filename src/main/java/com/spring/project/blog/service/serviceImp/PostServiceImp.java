package com.spring.project.blog.service.serviceImp;

import com.spring.project.blog.model.entity.Post;
import com.spring.project.blog.model.repository.PostRepository;
import com.spring.project.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
