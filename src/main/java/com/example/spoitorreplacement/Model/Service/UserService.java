package com.example.spoitorreplacement.Model.Service;

import com.example.spoitorreplacement.Model.Dtos.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {


   List<User> getAllUser();
   List<User> getUserByUsername (String userName);
   User saveUser(UserRequestDto userRequestDto);


}
