package com.sysmap.api.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sysmap.api.model.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}