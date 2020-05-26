package com.lxf.controller;

import com.lxf.domain.Product;
import com.lxf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println("方法执行......");
        System.out.println(product.getCityName());
        productService.save(product);

        return "redirect:findAll.do";

    }

    // 查询所有
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }
}
