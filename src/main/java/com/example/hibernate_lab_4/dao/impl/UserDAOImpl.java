package com.example.hibernate_lab_4.dao.impl;

import com.example.hibernate_lab_4.dao.UserDAO;
import com.example.hibernate_lab_4.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager manager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = manager.unwrap(Session.class);

        return session.createQuery("from User ", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        Session session = manager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        Session session = manager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        Session session = manager.unwrap(Session.class);
        User user;
        try {
            user = session.createQuery("from User where login = :login", User.class).setParameter("login", login).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = manager.unwrap(Session.class);

        Query query = session.createQuery("delete from User where id =:e");
        query.setParameter("e", id);
        query.executeUpdate();
    }
}