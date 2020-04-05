package com.factory.service.impl;

import com.factory.dao.AccountDao;
import com.factory.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * 用于创建对象的注解：
 *         作用和xml配置文件中编写一个<bean></bean>标签实现的功能一样
 *         @Component: 用于把当前类对象存入spring容器中
 *         属性： value 用于指定bean的id,若不写，默认是当前类名，且首字母改小写
 *
 *         @Controller: 用在表现层
 *         @Service： 一般用在业务层
 *         @Repository： 一般用在持久层
 *         以上的三个注解的作用和属性与@Component一样，他们是spring框架为我们提供明确的三层使用注解，使我们的三层对象更加清晰。
 * 用于注入数据的注解
 *          @Autowired: 自动按照类型注入，容器中有唯一的bean对象类型和要注入的变量类型匹配，就可以注入成功
 *          如果ioc容器中没有一个bean类型和要注入的d的变量类型匹配，则报错。
 *          如果ioc容器中有多个类型匹配时：
 *
 *          出现位置：可以是变量上，也可以是方法上
 *          在使用注解方法注入时，set方法不是必须的了
 *
 *
 *          @Qualifier: 在类型注入的基础上，再按照名称注入。他在给类成员注入时，不能单独使用，但在给方法参数注入时可以
 *          属性： value 用于指定注入bean的id
 *
 *          @Resource: 直接按照bean的id注入，它可以单独使用，
 *          属性： name 用于指定注入bean的id
 *          以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用以上注解。另外集合类型的注入只能通过xml来实现。
 *
 *          @Value: 用于基本类型和String类型的注入注解
 *          属性： value，用于指定数据的值，它可以使用spring中的SpEL(即spring中的el表达式）
 *              SpEL的写法： ${表达式}
 *
 *
 * 用于改变作用范围的：
 *          @Scope 用于指定bean的作用范围
 *          属性： 指定范围的取值，singleton prototype
 * 和生命周期相关：
 *          @Predestroy: 用于指定销毁方法
 *          @PostConstruct: 用于指定初始化方法
 */
@Service("accountService")
@Scope("singleton")
public class AccountServiceImpl implements AccountService {
    @Resource(name="accountDao1")
    private AccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
