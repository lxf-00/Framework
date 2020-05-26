package com.lxf.service;

import com.lxf.domain.Permission;
import com.lxf.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Permission> findOtherPermission(String roleId);

    Role findById(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
