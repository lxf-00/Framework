package com.springmvc.controller;

import com.springmvc.domain.Account;
import com.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/params")
public class ParmasController {
    /**
     * 简单演示
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/test")
    public String test(String username, String password){
        System.out.println(username + "...." + password);
        return "success";
    }

    /**
     * 请求参数绑定： 数据封装到JavaBean对象中
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 获取原生ServletAPI
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println(req);

        HttpSession session = req.getSession();
        System.out.println(session);

        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        return "success";
    }
}
