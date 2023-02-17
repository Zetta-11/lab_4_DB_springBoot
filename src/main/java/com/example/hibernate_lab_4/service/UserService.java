package com.example.hibernate_lab_4.service;

import com.example.hibernate_lab_4.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public User getUserByLogin(String login);

    public void deleteUser(int id);
}
