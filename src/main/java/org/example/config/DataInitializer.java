package org.example.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@EnableWebMvc
@ComponentScan(basePackages = "org.example")
public class DataInitializer {

    private final UserService userService;

    @PostConstruct
    public void init() {
        userService.createUser(new User(UUID.randomUUID(), "admin", "admin123"));
        userService.createUser(new User(UUID.randomUUID(), "test", "test"));
        userService.createUser(new User(UUID.randomUUID(), "misha", "Sen-Sey"));
        userService.createUser(new User(UUID.randomUUID(), "dima", "PRO"));
        userService.createUser(new User(UUID.randomUUID(), "durak", "123"));
    }
}
