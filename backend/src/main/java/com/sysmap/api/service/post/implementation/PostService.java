package com.sysmap.api.service.post.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.api.domain.embedded.Comment;
import com.sysmap.api.domain.model.Post;
import com.sysmap.api.domain.repo.PostRepository;
import com.sysmap.api.service.comment.dto.CommentRequest;
import com.sysmap.api.service.post.IUserPostService;
import com.sysmap.api.service.post.dto.CreatePostRequest;
@Service
public class PostService implements IUserPostService {
    @Autowired
    private PostRepository postRepo;
    public String createPost(CreatePostRequest request) {
        var post = new Post(request.getTitle(), request.getBody(), request.getCategory(), request.getTags());
            postRepo.save(post);
            return post.getId().toString();
    } 
   
    
    //retorna todos os posts
    @Override
    public List<Post> findPosts() {
        return postRepo.findAll();
    }

         
    @Override
    //deleta pelo titulo do post
    public void deletePost(String title) {
        postRepo.deleteByTitle(title);
    }
    
    @Override
    public void saveCommentToList(Comment comment, String postId) {
        var post = postRepo.findById(postId);
        if(post.isPresent()) {
            post.get().getComments().add(comment);
            postRepo.save(post.get());
        }
       }
    @Override
    public void updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate) throws Exception {
        var post = postRepo.findById(postId);
        if(post.isPresent()) {
            var comment = post.get().getComments().stream().filter(c -> c.getId().equals(commentId)).findFirst();
            if(comment.isPresent()) {
                comment.get().setBody(dataToUpdate.getBody());
                postRepo.save(post.get());
            }else {
                throw new Exception("Comment not found");
            }
        }
    }
    @Override
    //atualizar o post pelo titulo
    public void updatePost(String postId, CreatePostRequest dataToUpdate) throws Exception {
        var post = postRepo.findById(postId);
        if(post.isPresent()) {
            post.get().setTitle(dataToUpdate.getTitle());
            post.get().setBody(dataToUpdate.getBody());
            post.get().setCategory(dataToUpdate.getCategory());
            post.get().setTags(dataToUpdate.getTags());
            postRepo.save(post.get());
        }else {
            throw new Exception("Post not found");
        }
    }

    @Override
    public void deleteCommentToPost(String postId, String commentId) throws Exception {

    var post = postRepo.findById(postId);
    if(post.isPresent()) {
        var comment = post.get().getComments().stream().filter(c -> c.getId().equals(commentId)).findFirst();
        if(comment.isPresent()) {
            post.get().getComments().remove(comment.get());
            postRepo.save(post.get());
        }else {
            throw new Exception("Comment not found");
        }
    }
}    

}