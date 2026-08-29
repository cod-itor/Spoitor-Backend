package com.example.spoitorreplacement.Controller;

import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Response.ApiResponse;
import com.example.spoitorreplacement.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.apache.coyote.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ser.jdk.JDKKeySerializers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@Builder
@RequestMapping("/api/v1/User")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUser(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "5") Integer size ){
        List<User> userList = userService.getAllUser(page , size);
        ApiResponse<List<User>> response = ApiResponse.<List<User>>builder()
                .success(true)
                .messages("Fetched the Data")
                .status(HttpStatus.OK)
                .payload(userList)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("{user-name}")
    public ResponseEntity<User> getUserById(@PathVariable("user-name") String userName){
        return ResponseEntity.ok(userService.getUserByName(userName));
    }
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.saveUser(userRequestDto));
    }
    @PutMapping("{user-name}")
    public ResponseEntity<ApiResponse<User>> updateUserByName(
            @PathVariable("user-name") String userName,
            @RequestBody UserRequestDto userRequestDto) {
        User updatedUser = userService.updateUserByName(userName, userRequestDto);
        ApiResponse<User> response = ApiResponse.<User>builder()
                .success(true)
                .messages("Updated the User")
                .status(HttpStatus.OK)
                .payload(updatedUser)
                .timestamp(Instant.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{user-name}")
    public ApiResponse<String> deleteUserByName(@PathVariable("user-name") String userName){
        userService.deleteUserByName(userName);
        return  ApiResponse.<String>builder()
                .success(true)
                .messages("Deleted the Data")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(Instant.now())
                .build();
    }

}
