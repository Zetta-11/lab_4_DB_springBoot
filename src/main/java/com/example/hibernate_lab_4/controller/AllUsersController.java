package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AllUsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public String showMainPage(Model model) {
        List<User> users = userService.getAllUsers();

        model.addAttribute("allUsers", users);

        return "all-users";
    }
}
