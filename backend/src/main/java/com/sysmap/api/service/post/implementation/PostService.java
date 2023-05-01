package com.sysmap.api.service.post.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.api.model.entities.Post;
import com.sysmap.api.model.repository.PostRepository;
import com.sysmap.api.service.post.IUserPostService;
import com.sysmap.api.service.post.dto.CreatePostRequest;

@Service
public class PostService implements IUserPostService {
    @Autowired
    private PostRepository postRepo;

    public String createPost(CreatePostRequest request) {
        var post = new Post(request.title, request.body, request.author, request.category, request.tags, request.date);
       
        postRepo.save(post);
        return  ResponseEntity.ok("Your post was created successfully").toString();
    }
}