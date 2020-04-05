package com.springMVC.controller;

import com.springMVC.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回字符串，由视图解析器解析
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了。。。。。");
        // 模拟从数据库中查询用户并返回给页面
        User user = new User();
        user.setUsername("小明");
        user.setPassword("l123");
        user.setAge(20);

        // 存入Request域中
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * f返回为空
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("testVoid方法执行了。。。。。");

        // 请求转发的新的页面: 一次请求
        // req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req, resp);

        // 重定向： 两次请求
        // resp.sendRedirect(req.getContextPath() + "/index.jsp");

        // 直接进行响应
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("直接响应");
        return;
    }

    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        ModelAndView mv = new ModelAndView();
        System.out.println("testString方法执行了。。。。。");
        // 模拟从数据库中查询用户并返回给页面
        User user = new User();
        user.setUsername("小华");
        user.setPassword("23");
        user.setAge(20);

        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }

    /**
     * 关键字：请求转发和重定向
     * @return
     */
    @RequestMapping("/testForwardAndRedirect")
    public String testForwardAndRedirect(){
        System.out.println("testForwardAndRedirect方法执行.....");

        // 请求转发：forward
        // return "forward:/WEB-INF/pages/success.jsp";
        // 重定向：redirect
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行.....");
        System.out.println(user);
        return user;
    }
}
