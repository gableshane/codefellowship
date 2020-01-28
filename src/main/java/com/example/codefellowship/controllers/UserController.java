package com.example.codefellowship.controllers;

import com.example.codefellowship.models.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public RedirectView registerUser(String username,String password){

        AppUser newUser = new AppUser(username,passwordEncoder.encode(password));

        userRepository.save(newUser);

        return new RedirectView("/");
    }
    @PostMapping("/login")
    public String loginPage(){
        return "home";
    }

}
