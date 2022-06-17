package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.UserEntity;
import com.example.bestix.infrastructure.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Override
    public String getUserData(int userId) {
        return usersRepository.getUserById(userId);

      
    public UserServiceImplementation(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public void changeUserPasswordById(int userId, String password) {
        this.userRepository.changeUserPasswordById(userId, password);
    }
}
