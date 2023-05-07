package com.sysmap.api.service.comment.events;

import com.sysmap.api.domain.embedded.Comment;

public interface IveEventService {
    void send(String event);
    void consumer(Comment comment);
}
