package com.example.codefellowship.controllers;


import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.security.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Principal p, Model m){

        System.out.println(p);
        if(p != null){
            m.addAttribute("username",p.getName());
        }
        return "home";
    }
}
