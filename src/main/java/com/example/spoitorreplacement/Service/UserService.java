package com.example.spoitorreplacement.Service;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Response.UserResponseDto;

import java.util.List;

public interface UserService {

   List<User> getAllUser(int offset , Integer size);
   User getUserByName(String userName);
   User saveUser(UserRequestDto userRequestDto);



}
