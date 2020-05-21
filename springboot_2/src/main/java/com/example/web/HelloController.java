package com.example.web;



import com.example.pojo.User;
import com.example.service.UserService;
import com.oracle.tools.packager.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Slf4j
@Controller
@RequestMapping("/user")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User hello(@PathVariable("id") Integer id){
        return  userService.queryById(id);
    }
}
