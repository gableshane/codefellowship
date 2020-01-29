package com.example.codefellowship.models;

import javax.persistence.*;
import java.time.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    AppUser appUser;

    String body;

    LocalDateTime createdAt;

    public Post(String body, AppUser appUser){
        this.body = body;
        this.appUser = appUser;
        this.createdAt = LocalDateTime.now();
    }

    public Post(){}


    public AppUser getAppUser() {
        return appUser;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }
}
