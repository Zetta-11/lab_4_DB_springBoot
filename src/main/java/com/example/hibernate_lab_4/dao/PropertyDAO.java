package com.example.hibernate_lab_4.dao;

import com.example.hibernate_lab_4.entity.Property;

import java.util.List;

public interface PropertyDAO {

    public List<Property> getAllProperties();

    public void saveProperty(Property property);

    public Property getProperty(int id);

    public void deleteProperty(int id);
}
