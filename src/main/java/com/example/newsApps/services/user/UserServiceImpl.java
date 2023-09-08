package com.example.newsApps.services.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.newsApps.config.JwtUtil;
import com.example.newsApps.models.Role;
import com.example.newsApps.models.User;
import com.example.newsApps.payload.request.UserForgotRequest;
import com.example.newsApps.payload.request.UserLoginRequest;
import com.example.newsApps.payload.request.UserRegisRequest;
import com.example.newsApps.payload.response.ResponseHandler;
import com.example.newsApps.repositories.RoleRepository;
import com.example.newsApps.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> addUserService(UserRegisRequest request, String role) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new NoSuchElementException("username sudah ada");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new NoSuchElementException("email sudah ada");
        }
        // cek req params role apakah ada isinya
        String sRole = (role.equals("") || Objects.isNull(role) || role.equals(null)) ? "ROLE_USER" : role;

        Role rUser = roleRepository.findByName(sRole);

        if (Objects.isNull(rUser)) {
            rUser = new Role(sRole);
            roleRepository.save(rUser);
        }

        Set<Role> roles = new HashSet<>();
        roles.add(rUser);

        // convert request menjadi model entity
        User user = new User(request.getName(), request.getUsername(), request.getUsername(),
                passwordEncoder.encode(request.getPassword()));
        // save ke db
        user.setRoles(roles);

        userRepository.save(user);
        return ResponseHandler.responseData(201, "user berhasil ditambahkan!", user);

    }

    @Override
    public ResponseEntity<?> loginUserService(UserLoginRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());

        // autentikasi usernya
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // buatkan security context holdernya
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // generate token jwt.
        // token dengan 3 bagian, header, payload dan signature

        String token = jwtUtil.createToken(request.getUsername());

        Map<String, Object> data = new HashMap<>();
        data.put("username", request.getUsername());
        data.put("token", token);

        // return ResponseHandler.responseMessage(200, "Success login!", true);
        return ResponseHandler.responseData(200, "Success login!", data);
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
    public ResponseEntity<?> updateUserService(String id, UserForgotRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("id user tidak ditemukan!");
        });

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        return ResponseHandler.responseMessage(201, "password berhasil diganti", true);
    }

}
