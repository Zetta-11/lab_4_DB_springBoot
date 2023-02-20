package com.example.hibernate_lab_4.service;

import com.example.hibernate_lab_4.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WorkerService {

    public List<Worker> getAllWorkers();

    public void saveWorker(Worker worker);

    public Worker getWorker(int id);

    public void deleteWorker(int id);
}
