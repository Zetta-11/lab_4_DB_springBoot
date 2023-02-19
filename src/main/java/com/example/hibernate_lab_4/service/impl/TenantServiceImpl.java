package com.example.hibernate_lab_4.service.impl;

import com.example.hibernate_lab_4.dao.TenantDAO;
import com.example.hibernate_lab_4.entity.Tenant;
import com.example.hibernate_lab_4.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantDAO tenantDAO;

    @Override
    public List<Tenant> getAllTenants() {
        return tenantDAO.getAllTenants();
    }

    @Override
    public void saveTenant(Tenant tenant) {
        tenantDAO.saveTenant(tenant);
    }

    @Override
    public Tenant getTenant(int id) {
        return tenantDAO.getTenant(id);
    }

    @Override
    public void deleteTenant(int id) {
        tenantDAO.deleteTenant(id);
    }
}