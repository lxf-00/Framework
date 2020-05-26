package com.lxf.controller;

import com.lxf.domain.SysLog;
import com.lxf.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;
    private Class aClass;
    private Method method;

    // 前置通知，主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法
    @Before("execution(* com.lxf.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {

        visitTime = new Date(); // 访问时间
        aClass = joinPoint.getTarget().getClass(); // 访问的那个类
        // 获取执行的那个方法
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();// 获取访问方法的参数
        if(args == null || args.length == 0) {
            method = aClass.getMethod(methodName); //  获取无参构造方法
        }else{
            Class[] classArgs = new Class[args.length];
            for(int i = 0; i < args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            method = aClass.getMethod(methodName,classArgs);
        }

    }

    // 后置通知
    @After("execution(* com.lxf.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        // 获取访问时长
        Long time = new Date().getTime() - visitTime.getTime();

        String url = "";
        // 获取访问的url
        if(aClass != null && method != null && aClass != LogAop.class ){
            // 获取类上的RequestMapping
            RequestMapping classAnnotation = (RequestMapping)aClass.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                String[] classValue = classAnnotation.value();
                // 获取方法上的注解值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        }

        // 获取访问的ip地址
        String ip = request.getRemoteAddr();

        // 获取操作的用户
        SecurityContext context = SecurityContextHolder.getContext(); // 从上下文中获取当前登录用户
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();

        // 封装SysLog对象
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(time);  // 执行时间
        sysLog.setIp(ip); // ip地址
        sysLog.setMethod("【类名】"+aClass.getName() + "【方法名】"+method.getName());  // 方法名
        sysLog.setUrl(url);  // 访问url
        sysLog.setVisitTime(visitTime);  // 访问时间
        sysLog.setUsername(username);   // 用户

        // 调用service访问，存入数据库中
        sysLogService.save(sysLog);
    }

}
