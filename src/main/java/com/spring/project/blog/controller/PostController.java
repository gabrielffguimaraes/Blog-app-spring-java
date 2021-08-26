package com.spring.project.blog.controller;

import com.spring.project.blog.model.entity.Post;
import com.spring.project.blog.model.repository.PostRepository;
import com.spring.project.blog.service.PostService;
import com.spring.project.blog.service.serviceImp.PostServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    @Autowired
    PostRepository r;
    @Autowired
    PostServiceImp postService;

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
    public ModelAndView newPost() {
        ModelAndView postForm = new ModelAndView("postForm");
        postForm.addObject("notShow","notShow");
        return postForm;
    }
    /*
    @PostMapping("newpost")
    public ModelAndView savePost(@Valid Post post,BindingResult result ,RedirectAttributes attributes) {
        ModelAndView ret = new ModelAndView();

        if(result.hasErrors()) {
            attributes.addFlashAttribute("errors","Erro ao salvar , Campos * obrigatórios devem ser preenchidos .");
            ret.setViewName("redirect:/newpost");
            return ret;
        }
        postService.save(new Post());
        ret.setViewName("redirect:/posts");
        return ret;
    }*/
    @PostMapping("newpost")
    public void savePost() {
        //ModelAndView ret = new ModelAndView();
        Post p = new Post();
        p.setData(LocalDate.now());
        r.save(p);
        //ret.setViewName("redirect:posts");
        //return ret;
    }
}
