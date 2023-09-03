package com.example.newsApps.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.newsApps.models.User;

@Component
public class UserValidation {

    public void validateUser(User user) {
        if (user == null || Objects.isNull(user)) {
            throw new NoSuchElementException("user is not found!");
        }
    }
}
