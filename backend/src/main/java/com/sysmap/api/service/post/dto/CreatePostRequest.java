package com.sysmap.api.service.post.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class CreatePostRequest { 
    public UUID id;
    public String title;
    public String body;
    public String category;
    public String tags;

}
