package com.example.hibernate_lab_4.dao;

import com.example.hibernate_lab_4.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}