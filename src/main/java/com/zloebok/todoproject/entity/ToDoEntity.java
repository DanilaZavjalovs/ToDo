package com.zloebok.todoproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "ToDo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Date created;
    
    private Date updated;

    @PrePersist
    protected void onCreated() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdated() {
        updated = new Date();
    }
}
