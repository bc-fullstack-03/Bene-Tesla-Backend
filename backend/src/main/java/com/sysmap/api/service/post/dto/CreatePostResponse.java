package com.sysmap.api.service.post.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CreatePostResponse {
    private UUID id;
    private String title;
    private String body;
    private String category;
    private String tags;
   
    
    public CreatePostResponse(UUID id, String title, String body, String category, String tags) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.body = body;
        this.category = category;
        this.tags = tags;
        
    }

}
