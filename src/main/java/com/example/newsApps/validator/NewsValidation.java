package com.example.newsApps.validator;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.newsApps.models.News;

@Component
public class NewsValidation {

    public void validateNews(News news) {
        if (news == null || Objects.isNull(news)) {
            throw new NoSuchElementException("news is not found!");
        }
    }
}
