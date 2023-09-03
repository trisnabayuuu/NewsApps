package com.example.newsApps.services.user;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.News;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.UserForgotRequest;
import com.example.newsApps.payload.request.UserLoginRequest;
import com.example.newsApps.payload.request.UserRegisRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> addUserService(UserRegisRequest request) {
        if (userRepository.existsByUsername(request.getUsername())){
            throw new NoSuchElementException("username sudah ada");
        }
        if (userRepository.existsByEmail(request.getEmail())){
            throw new NoSuchElementException("email sudah ada");
        }
        // convert request menjadi model entity
        User user = new User(request.getName(), request.getUsername(), request.getEmail(), request.getPassword(), request.getIsAdmin());
        // save ke db
        userRepository.save(user);
        return ResponseHandler.responseMessage(201, "user berhasil ditambahkan!", true);
    
    }
    


    @Override
    public ResponseEntity<?> getUserByIdService(String id) {
        // kasih validator user id
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id user is not found!");
        });
    return ResponseHandler.responseData(200, "Success", user);
    }
    
    @Override
    public ResponseEntity<?> getUserService(Boolean isDeleted) {
        List<User> user = new ArrayList<>();

        if (isDeleted == null) {
            user = userRepository.findAll();
        } else {
            user = userRepository.findByIsDeleted(isDeleted);
        }

        return ResponseHandler.responseData(200, "sukses", user);
    }

    @Override
    public ResponseEntity<?> loginUserService(UserLoginRequest request) {
        // login
        // validasi username
        if (!userRepository.existsByUsername(request.getUsername())){
            throw new NoSuchElementException("username tidak ada");
        }
        User user = userRepository.findByUsername(request.getUsername());

        // validasi password
        if (!user.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Bad Credentials: password tidak sesuai");
        }
            return ResponseHandler.responseData(200, "success", user);
    }

    @Override
    public ResponseEntity<?> updateUserService(String id, UserForgotRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id user tidak ditemukan!");
        });
        
        user.setPassword(request.getPassword());
        userRepository.save(user);
        
        return ResponseHandler.responseMessage(201, "password berhasil diganti", true);
    }
    
}
