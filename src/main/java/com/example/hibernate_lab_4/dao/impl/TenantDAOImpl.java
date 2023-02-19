package com.example.hibernate_lab_4.dao.impl;

import com.example.hibernate_lab_4.dao.TenantDAO;
import com.example.hibernate_lab_4.entity.Tenant;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TenantDAOImpl implements TenantDAO {

    @Autowired
    private EntityManager manager;

    @Override
    @Transactional
    public List<Tenant> getAllTenants() {
        Session session = manager.unwrap(Session.class);

        return session.createQuery("from Tenant ", Tenant.class).getResultList();
    }

    @Override
    @Transactional
    public void saveTenant(Tenant tenant) {
        Session session = manager.unwrap(Session.class);

        session.saveOrUpdate(tenant);
    }

    @Override
    @Transactional
    public Tenant getTenant(int id) {
        Session session = manager.unwrap(Session.class);

        return session.get(Tenant.class, id);
    }

    @Override
    @Transactional
    public void deleteTenant(int id) {
        Session session = manager.unwrap(Session.class);

        Query query = session.createQuery("delete from Tenant where id =:e");
        query.setParameter("e", id);
        query.executeUpdate();
    }
}
