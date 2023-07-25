package com.phoneshop.shop.service;

import com.phoneshop.shop.dto.UserDTO;
import com.phoneshop.shop.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User dto);

    void deleteUser(String id);

    void updateUser(UserDTO dto);

    UserDTO searchUser(String id);

    UserDTO searchUserbyname(String name);

    List<UserDTO> getAllUsers();

    User getLastRecord();

}
