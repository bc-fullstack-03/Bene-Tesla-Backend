package com.sysmap.api.domain.embedded;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import java.util.List;
import java.util.ArrayList;

@Getter
public class Comment {
    @Id private UUID  id;
    private String body;
    private UUID post_id;
    private UUID author_id;
    private List<Like> likes;
    public Comment(String body, UUID uuid){
        this.id = UUID.randomUUID();
        this.body = body;
        this.post_id = uuid;
        this.author_id = uuid;
        this.likes = new ArrayList<>();
    }
    
    public static Comment create(String body, UUID uuid){
        return new Comment(body, uuid);    
    }

    public void setBody(String body){
        this.body = body;
    }

    
}
