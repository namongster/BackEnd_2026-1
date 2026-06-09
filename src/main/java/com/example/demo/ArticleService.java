package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleService{
    private final ArticleRepository repository;
    protected int nextId = 1;
    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article creatArticle(Article article){// Article 생성
        article.setId(nextId++);
        article.setCreatedAt(LocalDate.now());
        repository.articles.put((int) article.getId(), article);
        return article;
    }
    public Article updateArticle(int id, Article article){// Article 수정
        if (!repository.articles.containsKey(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        article.setId(id);
        repository.articles.put(id, article);
        return article;
    }
    public Collection<Article> getALLarticles(){// 모든 Article 가져오기
        return repository.articles.values();
    }
    public Article getArticle(int id){// id를 참고하여 Article 가져오기
        Article article = repository.articles.get(id);

        if (article != null){
            return article;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    public Map<String, String> deleteArticle(int id){
        repository.articles.remove(id);
        Map<String, String> result = new HashMap<>();
        result.put("message", "삭제 완료");
        return result;
    }
}
