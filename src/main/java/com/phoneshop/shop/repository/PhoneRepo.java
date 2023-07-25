package com.phoneshop.shop.repository;

import com.phoneshop.shop.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepo extends JpaRepository<Phone, String> {
    Phone findById(int i);

    boolean existsById(int id);

    void deleteById(int id);

    Phone findFirstByOrderByIdDesc();
}
