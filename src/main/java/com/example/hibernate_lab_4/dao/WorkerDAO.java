package com.example.hibernate_lab_4.dao;

import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.entity.Worker;

import java.util.List;

public interface WorkerDAO {

    public List<Worker> getAllWorkers();

    public void saveWorker(Worker worker);

    public Worker getWorker(int id);

    public void deleteWorker(int id);
}
