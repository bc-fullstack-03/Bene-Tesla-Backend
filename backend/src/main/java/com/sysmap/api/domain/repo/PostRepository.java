package com.sysmap.api.domain.repo;

import com.sysmap.api.domain.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
  void deleteByTitle(String postTitle);
  Object findByTitle(String title);
}