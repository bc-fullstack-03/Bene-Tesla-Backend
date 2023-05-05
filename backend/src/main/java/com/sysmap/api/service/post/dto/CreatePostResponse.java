package com.sysmap.api.service.post.dto;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class CreatePostResponse {
    private UUID id;
    public String title;
    public String body;
    public String author;
    public String category;
    public String tags;
    public Date date;    
   
}
