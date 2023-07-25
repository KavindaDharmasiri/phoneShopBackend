package com.phoneshop.shop.controller;

import com.phoneshop.shop.entity.AuthRequest;
import com.phoneshop.shop.entity.User;
import com.phoneshop.shop.service.UserService;
import com.phoneshop.shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class WelcomeController {

    @Autowired
    UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to kavinda !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("token awa");

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil saveUser(@RequestBody com.phoneshop.shop.dto.UserDTO user) {

        System.out.println("user save");
        User user1 = new User();
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setType(user.getType());
        user1.setPassword(user.getPassword());
        userService.saveUser(user1);

        return new com.phoneshop.shop.util.ResponseUtil(200, "Save", null);
    }

}
