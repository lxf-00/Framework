package com.springmvc.controller;

import com.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg")
public class AnnoController {
    /**
     * 常用注解： @RequestParam
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name")String username){
        System.out.println(username);
        return "success";
    }

    /**
     * 常用注解： RequestBody 获取请求体内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * 常用注解： PathVariable
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println(id);
        return "success";
    }

    /**
     * 注解： RequestHeader 获取请求头
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * 注解： CookieValue 获取cookie的值
     * @param cookie
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    /**
     * 注解： ModelAttribute
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user){
        System.out.println("testModelAttribute执行....");
        System.out.println(user);
        return "success";
    }

    /*
    @ModelAttribute
    public User showUser(User user){
        // 模拟数据库中查询：根据用户名
        user.setBirthday(new Date());
        return user;
    }*/
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setBirthday(new Date());

        map.put("abc", user);
    }

    /**
     * 注解：SessionAttributes
     * 将数据存入Session域中，实现方法间共用，用在类上
     * 设置
     * @param model
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        // 将信息存入Request域中
        model.addAttribute("msg", "静静");
        return "success";
    }
    /**
     * 获取Session中的值
     * @param modelMap
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }


    @RequestMapping("/removeSessionAttributes")
    public String removeSessionAttributes(SessionStatus status){
        status.setComplete();
        return "success";
    }
}
