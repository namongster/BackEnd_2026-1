package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.ArticleController.articles;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("boardName","자유게시판");
        model.addAttribute("articles",ArticleController.articles.values());

        return "posts";
    }
}
