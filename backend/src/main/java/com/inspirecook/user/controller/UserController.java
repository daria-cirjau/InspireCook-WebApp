package com.inspirecook.user.controller;

import com.inspirecook.user.dto.UserDTO;
import com.inspirecook.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
    }

    @GetMapping("/findByEmail")
    public UserDTO findByEmail(@RequestBody String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) {
        if (userService.loginUser(userDTO)) {
            return ResponseEntity.accepted().body("User successfully logged in");
        }
        return ResponseEntity.badRequest().body("Log in failed");
    }

}
