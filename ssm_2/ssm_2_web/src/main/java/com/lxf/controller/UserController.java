package com.lxf.controller;

import com.lxf.domain.Role;
import com.lxf.domain.UserInfo;
import com.lxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // http://localhost:8080/user/addRoleToUser.do
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name="userId", required = true) String userId, @RequestParam(name="ids") String[] ids){
        System.out.println("userId:" + userId);
        System.out.println("ids:" + ids);
        userService.addRoleToUser(userId, ids);
        return "redirect:findAll.do";
    }


    // http://localhost:8080/user/findUserByIdAndAllRole.do?id=2AE5D97339174679AFE87F0C99A05624
    // 查询用户和可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id", required = true) String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 1. 根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        // 2. 根据用户id查询用户还可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        // 3. 返回应答
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;

    }

    // 根据用户id查找用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    // 保存用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){

        userService.save(userInfo);
        return "redirect:findAll.do";

    }

    // 查询所有用户
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {

        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        System.out.println(userList);
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }
}
