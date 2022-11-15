package com.zis.guavapay.service.impl;

import com.zis.guavapay.User;
import com.zis.guavapay.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final KafkaTemplate<String, User> template;

    @Override
    public void sendMessage(User data) {
        log.info(String.format("#### -&gt; Producing message -&gt; %s", data));
        template.send("users", "1", data);
//        Message<User> message = MessageBuilder
//                .withPayload(data)
//                .setHeader(KafkaHeaders.TOPIC, "users")
//                .build();
//        this.kafkaTemplate.send(message);
    }
}
