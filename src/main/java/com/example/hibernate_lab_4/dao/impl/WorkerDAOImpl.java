package com.example.hibernate_lab_4.dao.impl;

import com.example.hibernate_lab_4.dao.WorkerDAO;
import com.example.hibernate_lab_4.entity.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class WorkerDAOImpl implements WorkerDAO {

    @Autowired
    EntityManager manager;

    @Override
    @Transactional
    public List<Worker> getAllWorkers() {
        Session session = manager.unwrap(Session.class);

        return session.createQuery("from Worker", Worker.class).getResultList();
    }

    @Override
    @Transactional
    public void saveWorker(Worker worker) {
        Session session = manager.unwrap(Session.class);

        session.persist(worker);
    }

   @Override
   @Transactional
    public Worker getWorker(int id) {
        Session session = manager.unwrap(Session.class);

        return session.get(Worker.class, id);
    }

    @Override
    @Transactional
    public void deleteWorker(int id) {
        Session session = manager.unwrap(Session.class);

        Query query = session.createQuery("delete from Worker where id=:e", Worker.class);
        query.setParameter("e", id);
        query.executeUpdate();
    }
}
