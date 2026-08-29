package com.example.spoitorreplacement.Controller;

import com.example.spoitorreplacement.Model.Entities.User;
import com.example.spoitorreplacement.Model.Request.UserRequestDto;
import com.example.spoitorreplacement.Model.Response.ApiResponse;
import com.example.spoitorreplacement.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
@Tag(name = "User Management", description = "Endpoints for managing users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a paginated list of users")
    public ResponseEntity<ApiResponse<List<User>>> getAllUser(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {
        List<User> userList = userService.getAllUser(page, size);
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
    @Operation(summary = "Get user by username", description = "Retrieve user details by username")
    public ResponseEntity<User> getUserById(@PathVariable("user-name") String userName){
        return ResponseEntity.ok(userService.getUserByName(userName));
    }

    @PostMapping
    @Operation(summary = "Create user", description = "Create a new user in the system")
    public ResponseEntity<User> saveUser(@RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok(userService.saveUser(userRequestDto));
    }

    @PutMapping("{user-name}")
    @Operation(summary = "Update user", description = "Update an existing user's information by username")
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
    @Operation(summary = "Delete user", description = "Delete a user from the system by username")
    public ApiResponse<String> deleteUserByName(@PathVariable("user-name") String userName){
        userService.deleteUserByName(userName);
        return ApiResponse.<String>builder()
                .success(true)
                .messages("Deleted the Data")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(Instant.now())
                .build();
    }
}
