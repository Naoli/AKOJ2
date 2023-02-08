package com.iloan.spring.repositories;

import com.iloan.spring.models.JeuVideo;
import org.springframework.data.repository.CrudRepository;

public interface JeuRepository extends CrudRepository<JeuVideo, Integer> {
}
