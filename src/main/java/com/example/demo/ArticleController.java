package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@Controller
public class ArticleController{
    private final ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // GET /article/{id} : 특정 article 조회
    @ResponseBody
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable int id){
        return articleService.getArticle(id);
    }
    // GET /articles : 모든 article 조회
    @ResponseBody
    @GetMapping("/articles")
    public Collection<Article> getALLarticles(){
        return articleService.getALLarticles();
    }

    @GetMapping("/posts")
    public String posts(Model model) {

        model.addAttribute("boardName","자유게시판");
        model.addAttribute("articles",articleService.getALLarticles());


        return "posts";
    }
    // POST /article : 신규 article 생성
    @ResponseBody
    @PostMapping("/article")
    public Article creatArticle(@RequestBody Article article){
        return articleService.creatArticle(article);
    }

    // PUT /article/{id} : 특정 article 수정
    @ResponseBody
    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }

    // DELETE /article/{id} : 특정 article 삭제
    @ResponseBody
    @DeleteMapping("/article/{id}")
    public Map<String, String> deleteArticle(@PathVariable int id) {
        return articleService.deleteArticle(id);
    }

}
