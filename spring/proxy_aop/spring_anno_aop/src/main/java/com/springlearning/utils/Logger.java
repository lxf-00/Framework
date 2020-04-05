package com.springlearning.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于提供日志的工具类，它里面提供了公共代码
 */

@Component("logger")
@Aspect  // 表示当前类是一个切面类
public class Logger {
    @Pointcut("execution(* com.springlearning.service.impl.*.*(..))")
    public void pt1(){}
    /**
     * 前置通知
     */
    // @Before("pt1()")
    public void beforePrint(){
        System.out.println("Logger中的beforePrint方法开始就日志了....");
    }

    /**
     * 后置通知
     */
    // @AfterReturning("pt1()")
    public void afterReturnPrint(){
        System.out.println("Logger中的afterReturnPrint方法开始就日志了....");
    }
    /**
     * 异常通知
     */
    // @AfterThrowing("pt1()")
    public void throwPrint(){
        System.out.println("Logger中的throwPrint方法开始就日志了....");
    }

    /**
     * 最终通知
     */
    // @After("pt1()")
    public void afterPrint(){
        System.out.println("Logger中的afterPrint方法开始就日志了....");
    }

    /**
     * 环绕通知：
     *      问题：当我们配置了环绕通知后，切入点方法没有执行，而通知方法执行了
     *      分析：通过对比动态代理中的代码，得知动态代理比环绕通知有明确的切入点方法的调用。
     *      解决：spring框架为我们提供了一个接口，ProceedingJoinPoint,该接口有一个方法proceed(),此方法就明确表示调用切入点方法。
     *            该方法可以作为环绕通知的方法的参数，在程序执行时，spring会为我们提供该接口的实现类供我们使用
     *
*           spring的环绕通知是为我们提供一种可以在代码中手动控制增强方式何时执行的方式
     *
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            System.out.println("Logger中的aroundPrintLog方法开始就日志了....前置"); // 前置通知
            // 获取方法执行的参数
            Object[] args = pjp.getArgs();
            // 调用业务层方（切入点方法）
            rtValue = pjp.proceed(args);
            System.out.println("Logger中的aroundPrintLog方法开始就日志了....后置"); // 后置通知
            return rtValue;
        } catch (Throwable t){
            System.out.println("Logger中的aroundPrintLog方法开始就日志了....异常"); // 异常通知
            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger中的aroundPrintLog方法开始就日志了....最终"); // 最终通知
        }

    }

}
