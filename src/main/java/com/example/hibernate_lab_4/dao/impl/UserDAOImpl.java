package com.example.hibernate_lab_4.dao.impl;

import com.example.hibernate_lab_4.dao.UserDAO;
import com.example.hibernate_lab_4.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        session.persist(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        Session session = manager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getNullWorkerUsers() {
        Session session = manager.unwrap(Session.class);

        Query<User> query = session.createQuery("select u from User u left join fetch u.tenant left join fetch u.worker " +
                "where u.tenant = null and u.worker = null and u.accountType = :type", User.class);
        query.setParameter("type", "worker");

        return query.getResultList();
    }

    @Override
    @Transactional
    public List<User> getNullTenantUsers() {
        Session session = manager.unwrap(Session.class);

        Query<User> query = session.createQuery("select u from User u left join fetch u.tenant left join fetch u.worker " +
                "where u.tenant = null and u.worker = null and u.accountType = :type", User.class);
        query.setParameter("type", "tenant");

        return query.getResultList();
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