package com.example.newsApps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsApps.payload.request.UserForgotRequest;
import com.example.newsApps.payload.request.UserLoginRequest;
import com.example.newsApps.payload.request.UserRegisRequest;
import com.example.newsApps.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRegisRequest request){

            return userService.addUserService(request);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginRequest request) {
            return userService.loginUserService(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id ){
        return userService.getUserByIdService(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserPassword(@PathVariable @Valid String id, @RequestBody UserForgotRequest request){
        return userService.updateUserService(id, request);
    }

    @GetMapping
    public ResponseEntity<?> getKomentar(@RequestParam(value = "deleted", defaultValue = "") Boolean isDeleted){
        return userService.getUserService(isDeleted);
    }
}
