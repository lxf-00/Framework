package com.lxf.service;

import com.lxf.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
