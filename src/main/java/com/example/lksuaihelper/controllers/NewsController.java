package com.example.lksuaihelper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @GetMapping("/news")
    public String addViewNews() {
        return "news";
    }
}
