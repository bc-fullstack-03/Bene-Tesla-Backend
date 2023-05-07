package com.sysmap.api.domain.model;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sysmap.api.domain.embedded.Comment;
import com.sysmap.api.domain.embedded.Like;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Document(collection = "posts")
@Getter
@Setter
@Data
public class Post {
    @Id
    private UUID id;
    private String title;
    private String body;
    private String category;
    private String tags;
   
    
   
    public Post(String title, String body, String category, String tags) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.body = body;
        this.category = category;
        this.tags = tags;
       
    }   
    


    //comments post
    private List<Comment> comments = new java.util.ArrayList<>();
    public List<Comment> getComments() {
        return comments;
    }
    public List<Comment> addComment(Comment comment) {
        this.comments.add(comment);
        return this.comments;
    }
    public List<Comment> removeComment(Comment comment) {
        this.comments.remove(comment);
        return this.comments;
    }
    //likes post
    public List<Like>likes = new java.util.ArrayList<>();
    public List<Like> getLikes() {
        return likes;
    }
    public List<Like> addLike(Like like) {
        this.likes.add(like);
        return this.likes;
    }
}
