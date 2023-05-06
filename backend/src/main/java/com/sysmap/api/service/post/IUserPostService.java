package com.sysmap.api.service.post;

import java.util.List;

import com.sysmap.api.model.entities.Post;
import com.sysmap.api.service.comment.dto.CommentRequest;
import com.sysmap.api.service.embedded.Comment;
import com.sysmap.api.service.post.dto.CreatePostRequest;
import com.sysmap.api.service.post.dto.CreatePostResponse;

public interface IUserPostService {
    String createPost(CreatePostRequest request);
    List<Post> findPosts(CreatePostResponse response);
    void deletePost(String postId) throws Exception;
    void updatePost(String postId, CreatePostRequest dataToUpdate) throws Exception;
    void saveCommentToList(Comment comment, String postId);
    void updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate) throws Exception;
    void deleteCommentToPost(String postId, String commentId) throws Exception;

   
}
