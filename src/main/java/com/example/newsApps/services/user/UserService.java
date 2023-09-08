package com.example.newsApps.services.user;

import org.springframework.http.ResponseEntity;

import com.example.newsApps.payload.request.UserForgotRequest;
import com.example.newsApps.payload.request.UserLoginRequest;
import com.example.newsApps.payload.request.UserRegisRequest;

public interface UserService {
    ResponseEntity<?> addUserService(UserRegisRequest request, String role);

    ResponseEntity<?> loginUserService(UserLoginRequest request);

    ResponseEntity<?> getUserByIdService(String id);

    ResponseEntity<?> getUserService(Boolean isDeleted);

    ResponseEntity<?> updateUserService(String id, UserForgotRequest request);
}
