package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.entity.User;

public interface UserServiceInterface {
    public String  registerUser(UserDTO userDTO);
    public String login(LoginRequest request);
}
