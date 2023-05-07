package com.sysmap.api.domain.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sysmap.api.domain.model.Post;

import java.util.UUID;

public interface CommentRepository extends MongoRepository<Post, UUID> {
    
}