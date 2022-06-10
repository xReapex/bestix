package com.example.bestix.domain.service;

import com.example.bestix.infrastructure.Entity.UserEntity;
import com.example.bestix.infrastructure.Repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    UsersRepository usersRepository;

    public UserServiceImplementation(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    @Override
    public String getUserData(int userId) {
        return usersRepository.getUserById(userId);
    }
}
