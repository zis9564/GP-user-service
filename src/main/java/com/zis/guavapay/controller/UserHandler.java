package com.zis.guavapay.controller;

import com.zis.guavapay.User;
import com.zis.guavapay.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserHandler{

    private final UserServiceImpl service;

    @Autowired
    public UserHandler(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/new-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> statements(@RequestBody User request) {
        service.sendMessage(request);
        return Mono.empty();
    }
}
