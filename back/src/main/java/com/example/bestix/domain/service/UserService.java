package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Repository.UserRepository;


public interface UserService {

    public void changeUserPasswordById(int userId, String password);
}
