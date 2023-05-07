package com.sysmap.api.service.comment.dto;

import java.util.List;
import java.util.UUID;

import com.sysmap.api.domain.embedded.Comment;
import com.sysmap.api.domain.embedded.Like;

import lombok.Data;

@Data
public class CommentResponse {
    private UUID id;
    private String body;
    private UUID post_id;
    private UUID author_id;
    private List<Like> likes;

    public CommentResponse(Comment params) {
        this.id = params.getId();
        this.body = params.getBody();
        this.post_id = params.getPost_id();
        this.author_id = params.getAuthor_id();
        this.likes = params.getLikes();
    }   
   
}
