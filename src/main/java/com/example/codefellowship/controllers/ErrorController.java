package com.example.codefellowship.controllers;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.security.*;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String returnError(){
        return "error";
    }
}
