package com.example.lksuaihelper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String addViewHome() {
        return "home";
    }

    @GetMapping("/login")
    public String addViewLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String getLoginInfo(String login, String password) {
        return "home";
    }
}
