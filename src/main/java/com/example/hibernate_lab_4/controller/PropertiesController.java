package com.example.hibernate_lab_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/allProperties")
public class PropertiesController {

    @GetMapping("")
    public String getAllProperties() {
        return "property/all-properties";
    }
}
