package com.example.spoitorreplacement.Controller;

import com.example.spoitorreplacement.Model.Entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {
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

    @GetMapping("/getAllUser")
    public ResponseEntity<ArrayList<User>> getAllUser() {
        return ResponseEntity.ok(userList);
    }

}
