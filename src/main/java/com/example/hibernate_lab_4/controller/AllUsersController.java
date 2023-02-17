package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.service.HouseService;
import com.example.hibernate_lab_4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AllUsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @GetMapping("/allUsers")
    public String showMainPage(Model model) {
        List<User> users = userService.getAllUsers();

        model.addAttribute("allUsers", users);

        return "all-users";
    }

    @GetMapping("/allUsers/addUser")
    public String addUser(Model model) {

        return "add-user";
    }

    @PostMapping("/allUsers/addUser")
    public String addUser(Model model, @RequestParam String login, @RequestParam String password,
                          @RequestParam String accountType) {
        User user = new User(login, password, accountType);
        user.setHouse(houseService.getHouse(1));
        userService.saveUser(user);

        return "redirect:/allUsers";
    }

    @GetMapping("/allUsers/{id}/edit")
    public String editUser(@PathVariable(value = "id") Integer id, Model model) {
        if (userService.getUser(id) == null) {
            return "redirect:/allUsers";
        }

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user-edit";
    }

    @PostMapping("/allUsers/{id}/edit")
    public String editUser(@PathVariable(value = "id") Integer id, Model model, @RequestParam String login, @RequestParam String password,
                           @RequestParam String accountType) {
        User user = userService.getUser(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setAccountType(accountType);
        userService.saveUser(user);

        return "redirect:/allUsers";
    }

    @PostMapping("/allUsers/{id}/remove")
    public String deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);

        return "redirect:/allUsers";
    }
}
