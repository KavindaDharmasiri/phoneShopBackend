package com.phoneshop.shop.service.impl;

import com.phoneshop.shop.dto.UserDTO;
import com.phoneshop.shop.entity.User;
import com.phoneshop.shop.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements com.phoneshop.shop.service.UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(User dto) {
        System.out.println(dto.getId());
        repo.save(mapper.map(dto, User.class));
    }

    @Override
    public void deleteUser(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(String.valueOf(dto.getId()))) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public UserDTO searchUser(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), UserDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public UserDTO searchUserbyname(String name) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.map(repo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public List<User> getByName(String name) {
        return mapper.map(repo.findByName(name), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public User getLastRecord() {
        return repo.findFirstByOrderByIdDesc();
    }
}

