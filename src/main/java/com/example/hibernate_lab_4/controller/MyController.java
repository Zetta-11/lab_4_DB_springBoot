package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showMainPage(Model model) {
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password) {
        User user = userService.getUserByLoginAndPassword(login, password);

        if (user == null) {
            return "redirect:/login";
        } else if (user.getAccountType().equals("tenant")) {
            return "panel/tenant-panel";
        } else if (user.getAccountType().equals("admin")) {
        return "panel/admin-panel";
        } else {
            return "panel/worker-panel";
        }
    }
}