package com.example.codefellowship.controllers;


import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.*;

import java.security.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/error")
    public RedirectView getError(){
        return new RedirectView("/");
    }
}
