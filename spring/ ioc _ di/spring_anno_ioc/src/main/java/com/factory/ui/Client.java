package com.factory.ui;

import com.factory.dao.AccountDao;
import com.factory.dao.impl.AccountDaoImp;
import com.factory.service.AccountService;
import com.factory.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层
 */
public class Client {
    /**
     * 获取spring IoC,并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     * 1. ClassPathXmlApplicationContext: 加载类路径下的配置文件，要求配置文件在类路径下
     * 2.FileSystemXmlApplicationContext：加载磁盘任意路径下的配置文件（必须要有访问权限）
     * 3.AnnotationConfigApplicationContext： 用于读取注解创建容器
     *
     * 核心容器两个接口引发的问题：
     * 1. ApplicationContext:  单例对象时适用
     *          构建核心容器，创建对象时采用的策略是立即加载方式，即读取完配置文件后立即创建配置文件中配置的对象。
     * 2. BeanFactory: 多例对象适用
     *          构建核心容器，创建对象时采用延迟加载方式，什么时候根据id创建对象，什么时候创建对象。
     * @param args
     */
    public static void main(String[] args) {
       // 1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 根据id获取bean对象
        AccountService service = (AccountService) ac.getBean("accountService");
        AccountService service1 = (AccountService) ac.getBean("accountService");
//        System.out.println(service);
//
//        AccountDao dao = ac.getBean("accountDao1",AccountDao.class);
//        System.out.println(dao );
        // System.out.println(service == service1);
        service.saveAccount();
        ((ClassPathXmlApplicationContext) ac).close();
    }

}
