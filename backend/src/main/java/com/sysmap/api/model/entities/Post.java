package com.sysmap.api.model.entities;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.sysmap.api.model.embedded.Comment;
import com.sysmap.api.model.embedded.Like;

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
    private String author;
    private String category;
    private String tags;
    private Date date;
    
   
    public Post(String title, String body, String author, String category, String tags, Date date) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.category = category;
        this.tags = tags;
        this.date = date;
        
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
