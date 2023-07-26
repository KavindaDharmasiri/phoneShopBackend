package com.phoneshop.shop.repository;

import com.phoneshop.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    List<User> findByName(String username);

    User findFirstByOrderByIdDesc();
}
