package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.News;
import com.example.hibernate_lab_4.entity.Property;
import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.HouseService;
import com.example.hibernate_lab_4.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/allProperties")
public class PropertiesController {

    @Autowired
    PropertyService propertyService;
    @Autowired
    HouseService houseService;

    @GetMapping("")
    public String getAllProperties(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());

        return "property/all-properties";
    }

    @GetMapping("/addProperty")
    public String addProperty(Model model) {
        model.addAttribute("property", new Property());

        return "property/add-property";
    }

    @PostMapping("/addProperty")
    public String addProperty(@ModelAttribute("property") Property property) {
        property.setHouse(houseService.getHouse(1));
        propertyService.saveProperty(property);

        return "redirect:/allProperties";
    }

    @GetMapping("/{id}/edit")
    public String editProperty(@PathVariable(value = "id") Integer id, Model model) {
        if (propertyService.getProperty(id) == null) {
            return "redirect:/allProperties";
        }
        model.addAttribute("properties", propertyService.getProperty(id));

        return "property/property-edit";
    }

    @PostMapping("/{id}/edit")
    public String editProperty(@PathVariable(value = "id") Integer id,
                               @ModelAttribute("properties") Property property) {

        propertyService.saveProperty(property);

        return "redirect:/allProperties";
    }

    @PostMapping("/{id}/remove")
    public String deleteProperty(@PathVariable(value = "id") Integer id) {

        if (propertyService.getProperty(id).getTenants() == null) {
            propertyService.deleteProperty(id);
        }
        return "redirect:/allProperties";

    }
}