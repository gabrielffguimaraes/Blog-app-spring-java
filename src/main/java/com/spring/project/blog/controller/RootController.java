package com.spring.project.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class RootController {
    @GetMapping("")
    public ModelAndView root() {
        ModelAndView m = new ModelAndView("index");
        return m;
    }
}
