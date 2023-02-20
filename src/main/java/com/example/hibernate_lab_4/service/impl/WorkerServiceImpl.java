package com.example.hibernate_lab_4.service.impl;

import com.example.hibernate_lab_4.dao.WorkerDAO;
import com.example.hibernate_lab_4.entity.Worker;
import com.example.hibernate_lab_4.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerDAO workerDAO;


    @Override
    public List<Worker> getAllWorkers() {
        return workerDAO.getAllWorkers();
    }

    @Override
    public void saveWorker(Worker worker) {
        workerDAO.saveWorker(worker);
    }

    @Override
    public Worker getWorker(int id) {
        return workerDAO.getWorker(id);
    }

    @Override
    public void deleteWorker(int id) {
        workerDAO.deleteWorker(id);
    }
}