package com.sysmap.api.service.client.events;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sysmap.api.service.client.IveEventService;

@Service
public class EventService implements IveEventService {
    
    @Autowired
    private KafkaTemplate<String, String> kafka;
    @Value("${topic.name}")
    private String topic;
    public void send(String event) {
        kafka.send(topic, event);
    }
    @KafkaListener(topics = "${topic.name}", groupId = "ms-demo")
    public void consumer(ConsumerRecord<String, String> event) {
           System.out.print("Event consumed: " + event.value());
    }
}