package com.phoneshop.shop.repository;

import com.phoneshop.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByName(String username);

    User findFirstByOrderByIdDesc();
}
