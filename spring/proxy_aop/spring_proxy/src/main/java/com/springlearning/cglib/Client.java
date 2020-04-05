package com.springlearning.cglib;

import com.springlearning.proxy.Iproducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的情况下，对方法进行增强
         * 2. 基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方cglib库
         *      如何创建代理对象： Enhancer create方法
         *      创建代理对象的要求：
         *          被代理类不能是最终类。
         *      create的参数：
         *          Class: 字节码
         *              指定被代理对象的字节码。固定写法
         *          Callback:用于提供增强的代码
         *              它是让我们写如何代理，我们一般是写一些接口的实现类，通常情况下都是匿名内部类，但无必须。
         *              此接口的实现类都是谁用，谁写。
         *              我们一般写的是该接口的子接口实现类：MethodInterceptor
         *
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何接口方法都会该方法
             * @param proxy
             * @param method
             * @param args
             * 以上与Invoke参数一致
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                // 提供增强的代码
                Object returnValue = null;
                // 1 获取方法执行的参数
                Float money = (Float) args[0];
                // 2 判断当前方法是否是销售
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(10000f);
    }
}
