package com.alumniportal.model;

import java.time.LocalDateTime;

public abstract class BaseEntity {

    private Long id;
    private LocalDateTime createdAt;

    public BaseEntity(Long id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}