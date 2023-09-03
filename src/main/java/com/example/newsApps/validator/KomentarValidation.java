package com.example.newsApps.validator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.newsApps.models.Komentar;
import com.example.newsApps.models.News;

@Component
public class KomentarValidation {
    public void validateKomentar(List<Komentar> komentarList) {
        if (komentarList == null || komentarList.isEmpty()) {
            throw new NoSuchElementException("Komentar list is empty or null!");
        }

        for (Komentar komentar : komentarList) {
            // Perform validation logic for each Komentar object
            if (komentar == null || Objects.isNull(komentar)) {
                throw new NoSuchElementException("Komentar is not found!");
            }
            
            // Add more validation rules for each Komentar object if needed
            // ...
        }
    }
}





