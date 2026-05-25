package com.example.demo;

import org.springframework.aop.interceptor.AbstractTraceInterceptor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Article {
    private long id;
    private String description;
    private String title;
    private String author;
    private LocalDate createdAt;

    public Article() {
    }

    public Article(long id, String description, String title, String author, LocalDate createdAt) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.author = author;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(String author){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public LocalDate getCreatedAt(LocalDate createdAt){
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt){
        this.createdAt = createdAt;
    }
}
