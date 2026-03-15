package com.example.spoitorreplacement.Model.Service.Impl;

import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    ArrayList<User> userList = new ArrayList<>(
            List.of(
                    new User("Coditor", "rector@gmail.com", "pass123", "Dita", "Rector", "012312", "Cambodia", "Phnom Penh", "Street 271"),
                    new User("TechGuru", "guru@example.com", "secure99", "Alice", "Smith", "098765", "USA", "New York", "5th Ave"),
                    new User("DevQueen", "dev@web.com", "logic77", "Srey", "Leak", "011223", "Cambodia", "Siem Reap", "Pub Street"),
                    new User("JavaKing", "java@oracle.com", "coffee88", "James", "Gosling", "055443", "Canada", "Calgary", "Maple St"),
                    new User("SpringMaster", "boot@spring.io", "leaf55", "Robert", "Martin", "077889", "USA", "Chicago", "Clean Road"),
                    new User("DataWizard", "data@analytix.com", "stats11", "Mony", "Vath", "066554", "Cambodia", "Battambang", "River Side"),
                    new User("CloudWalker", "cloud@sky.net", "vapor22", "Skylar", "Grey", "033221", "UK", "London", "Baker St"),
                    new User("PixelPerfect", "design@art.com", "color33", "Elena", "Voz", "099001", "France", "Paris", "Rue de Rivoli"),
                    new User("LogicByte", "byte@code.org", "bit44", "John", "Doe", "088776", "Australia", "Sydney", "Opera Lane"),
                    new User("BackendHero", "hero@server.com", "save00", "Bora", "Chan", "022334", "Cambodia", "Kampot", "Salt Field Rd")
            )
    );

    @Override
    public ArrayList<User> getAllUser() {
        return userList;
    }
    @Override
    public List<User> getUserByUsername(String userName){
        List<User> filterUsername = userList.stream()
                .filter(n -> n.getUserName().toLowerCase().contains(userName.toLowerCase()))
                .toList();
        return filterUsername ;
    }
    }