package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.Tenant;
import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.impl.TenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allTenants")
public class TenantsController {

    @Autowired
    TenantServiceImpl tenantService;

    @GetMapping("")
    public String showMainPage(Model model) {
        List<Tenant> tenants = tenantService.getAllTenants();

        model.addAttribute("allTenants", tenants);

        return "all-tenants";
    }

    @GetMapping("/addTenant")
    public String addTenant() {
        return "add-tenant";
    }

    @PostMapping("/addTenant")
    public String addTenant(Model model) {
        List<>

        return "redirect:/allTenants";
    }
}
