package com.lxf.controller;

import com.lxf.domain.Permission;
import com.lxf.domain.Role;
import com.lxf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // 保存用户
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    // 查询用户可以添加的角色
    // http://localhost:8080/user/findRoleByIdAndAllPermission.do?id=C01E9E0A7DF74B95ACC79FA26492D6C7
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndPermission(@RequestParam(name="id", required = true) String roleId){
        ModelAndView mv = new ModelAndView();
        // 1. 查询角色
        Role role = roleService.findById(roleId);
        // 2. 查询还可以添加的权限
        List<Permission> permissionList = roleService.findOtherPermission(roleId);
        // 3. 返回应答
        mv.addObject("permissionList", permissionList);
        mv.addObject("role", role);
        mv.setViewName("role-permission-add");
        return mv;
    }

    // 角色添加用户
    // http://localhost:8080/role/addPermissionToRole.do
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId", required = true) String roleId, @RequestParam(name="ids", required = true) String[] ids){

        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }

    // 查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        System.out.println(roles);
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;

    }
}
