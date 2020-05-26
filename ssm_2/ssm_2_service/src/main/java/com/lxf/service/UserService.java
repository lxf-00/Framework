package com.lxf.service;

import com.lxf.domain.Role;
import com.lxf.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] ids);
}
