package com.sysmap.api.service.post;

import com.sysmap.api.service.post.dto.CreatePostRequest;

public interface IUserPostService {
    String createPost(CreatePostRequest request);
}
