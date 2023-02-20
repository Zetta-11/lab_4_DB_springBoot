package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping("/allNews")
    public String showMainPage(Model model) {

        return "news/all-news";
    }
}
