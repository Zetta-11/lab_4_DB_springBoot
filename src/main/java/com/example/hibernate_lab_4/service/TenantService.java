package com.example.hibernate_lab_4.service;

import com.example.hibernate_lab_4.entity.Tenant;

import java.util.List;

public interface TenantService {

    public List<Tenant> getAllTenants();

    public void saveTenant(Tenant tenant);

    public Tenant getTenant(int id);

    public void deleteTenant(int id);
}
