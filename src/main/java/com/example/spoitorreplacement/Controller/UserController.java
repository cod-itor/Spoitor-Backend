package com.example.spoitorreplacement.Controller;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/{userName}")
    public ResponseEntity<List<User>> getUserById(@PathVariable String userName){
        return ResponseEntity.ok(userService.getUserByUsername(userName));
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.saveUser(userRequestDto));

    }
}
