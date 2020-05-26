package com.lxf.controller;

import com.github.pagehelper.PageInfo;
import com.lxf.domain.Orders;
import com.lxf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

   /* // 查询所有订单 -- 未分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-list");
        return  mv;
    }*/

    // 查询所有订单 -- 分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size){

        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        // pageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return  mv;
    }

    // 根据id，查询订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){

        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
