package com.sysmap.api.service.post.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CreatePostRequest {
    public String title;
    public String body;
    public String author;
    public String category;
    public String tags;
    public Date date;    
   
}
