package org.example.repository;

import org.example.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional(readOnly = true)
public interface UserRepository {

    @Transactional
    void save(User user);

    Optional<User> findById(UUID id);

    List<User> findAll();

    void update(User user);

    @Transactional
    void delete(UUID id);

    @Transactional
    void deleteAllUsers();
}