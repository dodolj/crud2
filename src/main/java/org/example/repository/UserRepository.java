package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User findById(UUID id) {
        return entityManager.find(User.class, id);
    }

    public List<User> findAll() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(UUID id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}