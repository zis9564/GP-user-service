package com.zis.guavapay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserHandler{

    @RequestMapping("/users")
    public Mono<User> getEmployeeById() {
        return Mono.just(new User("Hello Ivan"));
    }

}
