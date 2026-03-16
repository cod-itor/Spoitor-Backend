package com.example.spoitorreplacement.Service;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;

import java.util.List;

public interface UserService {


   List<User> getAllUser();
   List<User> getUserByUsername (String userName);
   User saveUser(UserRequestDto userRequestDto);


}
