package com.example.spoitorreplacement.Model.Service;

import com.example.spoitorreplacement.Model.Entities.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {


   ArrayList<User> getAllUser();
   List<User> getUserByUsername (String userName);
}
