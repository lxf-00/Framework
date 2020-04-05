package com.springMVC.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 跳转到具体的错误页面的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException ex = null;
        // 获取到异常对象
        if(e instanceof SysException){
            ex = (SysException) e;
        }else{
            ex = new SysException("请联系管理员");
        }
        ModelAndView mv = new ModelAndView();
        // 存入错误的信息
        mv.addObject("message", ex.getMessage());
        // 跳转到错误的页面
        mv.setViewName("error");
        return mv;
    }
}
