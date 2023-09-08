package com.example.newsApps.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @UuidGenerator
    private String id;

    @Column(unique = true)
    private String name;
    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updateAt;
    @JsonIgnore
    private Boolean isDeleted = false;
    
    public Role(String name) {
        this.name = name;
    }

    
}
