package com.example.hibernate_lab_4.service;

import com.example.hibernate_lab_4.entity.House;

import java.util.List;

public interface HouseService {

    public List<House> getAllHouses();

    public void saveHouse(House house);

    public House getHouse(int id);

    public void deleteHouse(int id);
}
