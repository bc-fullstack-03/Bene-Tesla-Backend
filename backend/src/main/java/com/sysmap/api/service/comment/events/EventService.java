package com.sysmap.api.service.comment.events;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sysmap.api.domain.embedded.Comment;

@Service
public class EventService implements IveEventService {    
    @Autowired
    private KafkaTemplate<String, String> kafka;
    @Value("${topic.name}")
    private String topic;
    public void send(String event) {
        kafka.send(topic, event);
    }
    @KafkaListener(topics = "${topic.name}", groupId = "ms-comment")
    public void consumer(Comment comment) {
       kafka.send(topic, comment.toString());
    }     
}