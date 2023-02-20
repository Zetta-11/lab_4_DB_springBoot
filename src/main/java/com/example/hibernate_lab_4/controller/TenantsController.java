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

        return "tenant/all-tenants";
    }

    @GetMapping("/addTenant")
    public String addTenant(Model model) {
        List<Property> properties = propertyService.getAllProperties();
        model.addAttribute("allProperties", properties);
        model.addAttribute("allUsers", userService.getNullTenantUsers());

        return "tenant/add-tenant";
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
    public String getProperty(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("properties", propertyService.getProperty(id));

        return "all-properties";
    }

    @GetMapping("/{id}/edit")
    public String editTenant(@PathVariable(value = "id") Integer id, Model model) {
        if (tenantService.getTenant(id) == null) {
            return "redirect:/allTenants";
        }

        Tenant tenant = tenantService.getTenant(id);

        model.addAttribute("allProperties", propertyService.getAllProperties());
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("tenant", tenant);

        return "tenant/tenant-edit";
    }

    @PostMapping("/{id}/edit")
    public String editTenant(@PathVariable(value = "id") Integer id, @RequestParam String name,
                             @RequestParam String surname, @RequestParam String phone,
                             @RequestParam Integer propertyNumber, @RequestParam String userLogin) {

        Tenant tenant = tenantService.getTenant(id);

        tenant.setName(name);
        tenant.setSurname(surname);
        tenant.setPhone(phone);
        tenant.setProperty(propertyService.getPropertyByNumber(propertyNumber));
        tenant.setUser(userService.getUserByLogin(userLogin));
        tenantService.saveTenant(tenant);

        return "redirect:/allTenants";
    }

    @PostMapping("/{id}/remove")
    public String deleteTenant(@PathVariable(value = "id") Integer id) {
        tenantService.deleteTenant(id);

        return "redirect:/allTenants";
    }
}
