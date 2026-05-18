package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

public class Article {
    private Map<Integer, Article> articles = new HashMap<>();
    private int nextId = 1;

    private long id;
    private String description;

    public Article(){}

    public Article(long id, String description){
        this.id = id;
        this.description = description;
    }

    public long GETid(){return id;}
    public void SETid(long id){ this.id = id;}
    public String GETdescription(){return description;}
    public void SETdescription(String description){this.description = description;}
}
