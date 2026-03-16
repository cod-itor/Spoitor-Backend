package com.example.spoitorreplacement.Controller;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("{user-name}")
    public ResponseEntity<User> getUserById(@PathVariable("user-name") String userName){
        return ResponseEntity.ok(userService.getUserByName(userName));
    }

}
