package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {
    protected Map<Integer, Article> articles = new HashMap<>();


}
