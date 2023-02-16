package com.example.hibernate_lab_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HousesController {

    @GetMapping("/allHouses")
    public String showMainPage(Model model) {
        model.addAttribute("Home", "Home page");

        return "all-houses";
    }
}
