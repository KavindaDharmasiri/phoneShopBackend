package com.phoneshop.shop.controller;

import com.phoneshop.shop.entity.User;
import com.phoneshop.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class UserController {

    private static final ArrayList<String> allImages = new ArrayList<>();
    String temp;

    @Autowired
    UserService userService;

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getAllUsers() {
        System.out.println("get all");
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", userService.getAllUsers());
    }

    @GetMapping(path = "/getByName", params = {"name"} , produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getByName(@RequestParam String name) {
        System.out.println("get all");
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", userService.getByName(name));
    }

    @GetMapping(path = "/getLast", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getLastUser() {
        System.out.println("get all");
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", userService.getLastRecord());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil saveUser(@RequestBody com.phoneshop.shop.dto.UserDTO user) {

        System.out.println("user save");
        System.out.println(user.getId());
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setType(user.getType());
        user1.setPassword(user.getPassword());
        temp = "";
        userService.saveUser(user1);

        return new com.phoneshop.shop.util.ResponseUtil(200, "Save", null);
    }


    @PutMapping(path = "/editUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil updateUser(@RequestBody com.phoneshop.shop.dto.UserDTO user) {
        userService.updateUser(user);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil searchUser(@PathVariable String id) {
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", userService.searchUser(id));
    }


}
