package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.UserEntity;
import com.example.bestix.infrastructure.Repository.UserRepository;

public interface UserService {
    String getUserData(int userId);
    public void changeUserPasswordById(int userId, String password);
}