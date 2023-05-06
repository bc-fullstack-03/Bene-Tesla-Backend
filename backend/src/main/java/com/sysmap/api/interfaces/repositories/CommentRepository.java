package com.sysmap.api.interfaces.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sysmap.api.model.entities.Post;
import java.util.UUID;

public interface CommentRepository extends MongoRepository<Post, UUID> {
    
}