package com.example.Login.Repo;

import com.example.Login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findOneByNameAndPassword(String name, String encodedPassword);
    User findByName(String name);
}
