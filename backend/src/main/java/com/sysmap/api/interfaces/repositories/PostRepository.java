package com.sysmap.api.interfaces.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sysmap.api.model.entities.Post;
import com.sysmap.api.service.post.dto.CreatePostRequest;
public interface PostRepository extends MongoRepository<Post, String> {
      void save(CreatePostRequest request);
}