package org.example.repository;

import org.example.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(UUID id);

    List<User> findAll();

    void update(User user);

    boolean delete(UUID id);
}