package com.iloan.spring.repositories;

import com.iloan.spring.models.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer>{


}
