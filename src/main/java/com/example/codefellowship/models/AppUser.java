package com.example.codefellowship.models;

import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany
    List<AppUser> usersThatIAmFollowing;


    @OneToMany(mappedBy = "appUser")
    List<Post> posts;

    String username;
    String password;
    String firstName;
    String lastName;
    String bio;
    String imgUrl;

    public AppUser(){}

    public AppUser(String username, String password, String firstName, String lastName, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.imgUrl = "/default.jpg";
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<AppUser> getUsersThatIAmFollowing(){
        return usersThatIAmFollowing;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBio() {
        return bio;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }
    public void addUserToFollow(AppUser userToFollow){
        this.usersThatIAmFollowing.add(userToFollow);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                '}';
    }
}
