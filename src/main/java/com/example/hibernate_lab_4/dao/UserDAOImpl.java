package com.example.hibernate_lab_4.dao;

import com.example.hibernate_lab_4.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager manager;

    @Override
    public List<User> getAllUsers() {
        Session session = manager.unwrap(Session.class);

        return session.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        Session session = manager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = manager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Session session = manager.unwrap(Session.class);

        Query query = session.createQuery("delete from User where id =:e");
        query.setParameter("e", id);
        query.executeUpdate();
        ;
    }
}