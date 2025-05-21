package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getUserId())) {
            return "User already exists";
        }

        User user = User.builder()
                .userId(userDTO.getUserId())
                .email(userDTO.getEmail())
                .fullName(userDTO.getFullName())
                .password(PasswordUtil.hashPassword(userDTO.getPassword()))
                .build();

        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(LoginRequest request) {
        return userRepository.findByUserId(request.getUserId())
                .map(user -> {
                    if (PasswordUtil.verifyPassword(request.getPassword(), user.getPassword())) {
                        return "Login successful";
                    }
                    return "Invalid credentials";
                }).orElse("User not found");
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



}
