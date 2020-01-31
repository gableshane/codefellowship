package com.example.codefellowship.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String returnError(){
        return "error";
    }
}
