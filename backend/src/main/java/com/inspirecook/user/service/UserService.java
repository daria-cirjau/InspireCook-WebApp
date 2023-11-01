package com.inspirecook.user.service;

import com.inspirecook.user.dto.UserDTO;
import com.inspirecook.user.entity.User;
import com.inspirecook.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findByEmail(String email) {
        return new UserDTO(userRepository.findByEmail(email));
    }

    public void registerUser(UserDTO userDTO) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encryptedPasswordByteArr = md.digest(userDTO.getPassword().getBytes(StandardCharsets.UTF_8));
            userRepository.insert(new User(userDTO.getEmail(), new String(encryptedPasswordByteArr)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean loginUser(UserDTO userDTO) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encryptedPasswordByteArr = md.digest(userDTO.getPassword().getBytes(StandardCharsets.UTF_8));
            User user = userRepository.findByEmailAndPassword(userDTO.getEmail(), new String(encryptedPasswordByteArr));
            return user != null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
