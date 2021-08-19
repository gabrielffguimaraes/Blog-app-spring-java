package com.spring.project.blog.controller;

import com.spring.project.blog.model.entity.Post;
import com.spring.project.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("posts")
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> posts = postService.findAll();
        modelAndView.addObject("posts",posts);
        return  modelAndView;
    }
    @GetMapping("posts/{id}")
    public ModelAndView getPostDetails(@PathVariable(name="id") Long id) {
        ModelAndView details = new ModelAndView("postDetails");
        Post p = postService.findById(id);
        details.addObject("post",p);
        return details;
    }
    @GetMapping("newpost")
    public String newPost() {
        return "postForm";
    }

    @PostMapping("newpost")
    public String savePost(@Valid @RequestBody Post post,BindingResult result ,RedirectAttributes attributes) {
        if(result.hasErrors()) {
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        postService.save(post);
        return "redirect:/posts";
    }
}
