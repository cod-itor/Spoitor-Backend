package com.example.spoitorreplacement.Service.Impl;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Response.ApiResponse;
import com.example.spoitorreplacement.Repository.UserRepository;
import com.example.spoitorreplacement.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser(int offset , Integer size) {
        int page  = (offset - 1)*size;
        return userRepository.getAllUser(page, size);

    }
    @Override
    public User getUserByName(String userName){
        return userRepository.getUserByName(userName);
    }
    @Override
    public User saveUser(UserRequestDto userRequestDto){
        return userRepository.saveUser(userRequestDto);
    }
}