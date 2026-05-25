package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;

@RestController
public class ArticleController {
    protected static Map<Integer, Article> articles = new HashMap<>();
    private int nextId = 1;

    // GET /article/{id} : 특정 article 조회
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable int id){
        Article article = articles.get(id);

        if (article != null){
            return article;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
    @GetMapping("/articles")
    public Collection<Article> getALLarticles(){
        return articles.values();
    }

    // POST /article : 신규 article 생성
    @PostMapping("/article")
    public Article creatArticle(@RequestBody Article article){
        article.setId(nextId++);
        articles.put((int) article.getId(), article);
        return article;
    }

    // PUT /article/{id} : 특정 article 수정
    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
        if (!articles.containsKey(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        article.setId(id);
        articles.put(id, article);
        return article;

    }

    // DELETE /article/{id} : 특정 article 삭제
    @DeleteMapping("/article/{id}")
    public Map<String, String> deleteArticle(@PathVariable int id) {
        articles.remove(id);
        Map<String, String> result = new HashMap<>();
        result.put("message", "삭제 완료");
        return result;
    }

}
