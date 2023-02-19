package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.Property;
import com.example.hibernate_lab_4.entity.Tenant;
import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.PropertyService;
import com.example.hibernate_lab_4.service.TenantService;
import com.example.hibernate_lab_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/allTenants")
public class TenantsController {

    @Autowired
    TenantService tenantService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    UserService userService;

    @GetMapping("")
    public String showMainPage(Model model) {
        List<Tenant> tenants = tenantService.getAllTenants();

        model.addAttribute("allTenants", tenants);

        return "all-tenants";
    }

    @GetMapping("/addTenant")
    public String addTenant(Model model) {
        List<Property> properties = propertyService.getAllProperties();
        model.addAttribute("allProperties", properties);
        model.addAttribute("allUsers", userService.getAllUsers());

        return "add-tenant";
    }

    @PostMapping("/addTenant")
    public String addTenant(@RequestParam String name, @RequestParam String surname,
                            @RequestParam String phone, @RequestParam Integer propertyNumber, @RequestParam String userLogin) {

        Property property = propertyService.getPropertyByNumber(propertyNumber);
        User user = userService.getUserByLogin(userLogin);

        Tenant tenant = new Tenant(name, surname, phone, user, property);
        tenantService.saveTenant(tenant);

        return "redirect:/allTenants";
    }

    @GetMapping("/{id}/property")
    public String getProperty(@PathVariable(value = "id") Integer id) {
        return "";
    }
}
