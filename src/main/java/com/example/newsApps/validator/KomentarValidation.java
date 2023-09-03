package com.example.newsApps.validator;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.example.newsApps.models.Komentar;

@Component
public class KomentarValidation {
    public void validateKomentar(List<Komentar> komentarList) {
        if (komentarList == null || komentarList.isEmpty()) {
            throw new NoSuchElementException("Komentar list is empty or null!");
        }

        for (Komentar komentar : komentarList) {
            if (komentar == null || Objects.isNull(komentar)) {
                throw new NoSuchElementException("Komentar is not found!");
            }
        }
    }
}





