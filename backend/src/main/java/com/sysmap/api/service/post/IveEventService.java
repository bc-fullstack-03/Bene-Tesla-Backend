package com.sysmap.api.service.post;

import com.sysmap.api.service.embedded.Comment;

public interface IveEventService {
    void send(String event);
    void consumer(Comment comment);
}
