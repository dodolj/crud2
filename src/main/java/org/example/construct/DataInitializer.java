package org.example.construct;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private static final Logger logger = Logger.getLogger(DataInitializer.class.getName());

    private final UserService userService;

    @PostConstruct
    public void init() {
        try {
            userService.createUser(new User(UUID.randomUUID(), "admin", "admin123"));
            userService.createUser(new User(UUID.randomUUID(), "test", "test"));
            userService.createUser(new User(UUID.randomUUID(), "misha", "Sen-Sey"));
            userService.createUser(new User(UUID.randomUUID(), "dima", "PRO"));
            userService.createUser(new User(UUID.randomUUID(), "durak", "123"));

            logger.info("Test users initialized successfully");
        } catch (Exception e) {
            logger.severe("Error during test data initialization: " + e.getMessage());
        }
    }
}