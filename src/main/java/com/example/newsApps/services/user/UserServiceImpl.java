package com.example.newsApps.services.user;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.newsApps.models.User;
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
        return ResponseHandler.responseMessage(201, "user successfully added!", true);
    
    }
    
    @Override
    public ResponseEntity<?> getUserByIdService(String id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResponseEntity<?> getUserService(Boolean isDeleted) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> loginUserService(UserLoginRequest request) {
        // login
        // validasi jika username tidak ada
        if (!userRepository.existsByUsername(request.getUsername())){
            throw new NoSuchElementException("username tidak ada");
        }
        User user = userRepository.findByUsername(request.getUsername());

        //validasi password
        // if (user.getIsDeleted()){
        //     throw new NoSuchElementException("user sudah dihapus");
        // }

        // validasi password
        if (!user.getPassword().equals(request.getPassword())) {
            throw new NoSuchElementException("Bad Credentials: password tidak sesuai");
        }
            return ResponseHandler.responseData(200, "success", true);
    }
    
}
