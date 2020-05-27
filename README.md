# Framework
Java Web Framework(mybatis, spring) learning
# 分层开发的常见框架
### 1. Mybatis: 解决数据持久化问题的框架
- [整体知识点](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%80%E9%83%A8%E5%88%86/learning_1/%E7%9F%A5%E8%AF%86%E7%82%B9)
- <strong>第一部分：<strong>
  - [Mybatis 基础主配置](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%80%E9%83%A8%E5%88%86/learning_1/src/main/resources/SqlMapConfig.xml)
  - [MyBatis mapper基础配置](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%80%E9%83%A8%E5%88%86/learning_1/src/main/resources/com/mybatisLearning/dao/UserDao.xml)
  - [简单使用](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%80%E9%83%A8%E5%88%86/learning_2/src/test/java/com/mybatisLearning/test/MyBatisTest.java)
  - [自定义mybatis(了解)](https://github.com/lxf-00/Framework/tree/master/mybatis/%E7%AC%AC%E4%B8%80%E9%83%A8%E5%88%86/learning_3/src/main/java/com/mybatisLearning/mybatis)
- 第二部分：
  - [基于xml的CRUD](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_4/src/main/resources/com/mybatis/dao/UserDao.xml)
  - [主配置属性：properties/typeAliases/package](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_5/src/main/resources/SqlMapConfig.xml);
  - [mapper xml配置属性：resultMap，selectKey](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_5/src/main/resources/com/mybatis/dao/UserDao.xml)
  - [mapper xml配置: 动态sql,抽取重复sql](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_6/src/main/resources/com/mybatis/dao/UserDao.xml)
  - [mapper xml配置： assocation(一对一)](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_7/src/main/resources/com/mybatis/dao/AccountDao.xml)[，collection(一对多)](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/learning_7/src/main/resources/com/mybatis/dao/UserDao.xml)
  - [xml 延迟加载：主配置、](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/lazyByAssociation/src/main/resources/SqlMapConfig.xml)[mapper 配置(assocation、collection)](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%BA%8C%E9%83%A8%E5%88%86/lazyByAssociation/src/main/resources/com/mybatis/dao/AccountDao.xml)
- <strong>第三部分：</strong>
  - [Mybatis 注解开发 - 主配置（无mapper xml配置)](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%89%E9%83%A8%E5%88%86/annotation_crud/src/main/resources/SqlMapConfig.xml)
  - [注解示例](https://github.com/lxf-00/Framework/blob/master/mybatis/%E7%AC%AC%E4%B8%89%E9%83%A8%E5%88%86/annotation_crud/src/main/java/com/mybatis/dao/UserDao.java)

### 2. spring: 解决技术整合问题的框架
```说明
Spring 是分层的 Java SE/EE 应用 full-stack 轻量级开源框架，
以 IoC(Inverse Of Control: 反转控制)和 AOP(Aspect Oriented Programming:面向切面编程)
为内核，提供了展现层 Spring MVC 和持久层 Spring JDBC 以及业务层事务管理等众多的企业级应用技
术，还能整合开源世界众多 著名的第三方框架和类库，逐渐成为使用最多的 Java EE 企业应用开源框架
```
- [整体知识点](https://github.com/lxf-00/Framework/blob/master/spring/spring%E7%9F%A5%E8%AF%86%E7%82%B9)
- <strong>第一部分<strong>
  - [耦合、解耦、解耦一：反射](https://github.com/lxf-00/Framework/blob/master/spring/%E8%A7%A3%E8%80%A6/program_jdbc_1/src/main/java/com/springlearning/jdbc/JdbcDemo1.java)
  - [解耦二:工厂模式](https://github.com/lxf-00/Framework/blob/master/spring/%E8%A7%A3%E8%80%A6/factory_2/src/main/java/com/factory/factory_test/FactoryBean.java)
  - 解耦三：控制反转IoC(Inverser of Control)
    - [IoC 基于XML配置](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/spring_2/src/main/resources/bean.xml)[, 简单使用](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/srping_1/src/main/java/com/factory/ui/Client.java)
    - [依赖注入(Dependency Injection)](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/srping_3_dependency_injection/src/main/resources/bean.xml)
    - [简单案例: CRUD](https://github.com/lxf-00/Framework/tree/master/spring/%20ioc%20_%20di/spring_ioc_xml_simplecase)
- <strong>第二部分<strong>:
  - [基于注解的IoC配置(带xml)：开启注解支持](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/spring_anno_ioc/src/main/resources/bean.xml)[,注解配置](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/spring_anno_ioc/src/main/java/com/factory/service/impl/AccountServiceImpl.java)
  - [IoC纯注解配置: @Configuration](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/spring_account_anno_without_xml/src/main/java/config/SpringConfig.java)
  - @PropertySource @Import
  - [spring 整合junit](https://github.com/lxf-00/Framework/blob/master/spring/%20ioc%20_%20di/spring_account_anno_without_xml/src/test/java/com/springlearning/test/AccountServiceTest.java)
- <strong>第三部分：</strong>
  - [动态代理一：基于接口 Proxy](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_proxy/src/main/java/com/springlearning/proxy/Client.java)
  - [动态代理二：基于子类 cglib](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_proxy/src/main/java/com/springlearning/cglib/Client.java)
  - [基于XML aop配置](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_aop/src/main/resources/bean.xml)
  - [环绕通知](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_aop/src/main/java/com/springlearning/utils/Logger.java)
  - [注解 aop配置： 开启aop注解支持](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_anno_aop/src/main/resources/bean.xml)
  - [注解 aop配置示例](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_anno_aop/src/main/java/com/springlearning/utils/Logger.java)
  - @EnableAspectJAutoProxy
  - [案例: 配置文件](https://github.com/lxf-00/Framework/blob/master/spring/proxy_aop/spring_account_promption/src/main/resources/bean.xml)
- <strong>第四部分：</strong>
  - [spring JdbcTemplate](https://github.com/lxf-00/Framework/tree/master/spring/transaction/spring_jdbcTemplate)
  - [事务控制： 基于xml的声明式事务控制配置](https://github.com/lxf-00/Framework/blob/master/spring/transaction/spring_tx/src/main/resources/bean.xml)
  - [事务控制： 基于注解的配置方式](https://github.com/lxf-00/Framework/blob/master/spring/transaction/spring_tx_anno/src/main/resources/bean.xml)
  - @Nullable 和 @NotNull 注解来显示表明可为空的参数以及返回值。这样就够在编译的时候处 理空值而不是在运行时抛出 NullPointerExceptions。

### 3. springMVC: 解决 WEB 层问题的框架
- <strong>第一部分：</strong>
  - [简单使用： pom.xml 示例](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/pom.xml)
  - [简单使用：web.xml 配置示例](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/webapp/WEB-INF/web.xml)
  - [简单使用： sprinmvc.xml 配置示例](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/resources/springMVC.xml)(注意在相应位置配置jsp/html)
  - [简单使用： controller 注解示例](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/java/com/springmvc/controller/HelloController.java)
  - 大体流程示意图
  ```mermaid
  graph TB
  tomcat启动--创建-->前端控制器
  subgraph 初始化化阶段
  前端控制器--加载配置--> 开启扫描,创建contorller对象
  end
  subgraph 请求阶段
  客户端 --发起请求--> 前端控制器 --注解--> 分配到具体contorller方法 --结果--> 视图解析器 --> 服务器渲染 --返回响应--> 客户端
  end    
  ```
  - [@RequestMapping、请求参数绑定](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/java/com/springmvc/controller/ParmasController.java)
  - [自定义类型转换器](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/java/com/springmvc/utils/StringToDate.java)(需在配置中注册转换器详见springmv.xml 配置示例)
  - 控制器中使用原生的ServletAPI对象：只需要在控制器的方法参数定义HttpServletRequest和HttpServletResponse对象
  - [常用注解：@RequestParam、@RequestBody、@PathVariable、 ](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_01_start/src/main/java/com/springmvc/controller/AnnoController.java)
- 第二部分：
  - [响应数据和结果视图](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_02_response/src/main/java/com/springMVC/controller/UserController.java)
  - [springMVC实现文件上传](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_03_fileupload/src/main/java/com/springMVC/controller/UserController.java)
  - [异常处理：自定义异常处理器](https://github.com/lxf-00/Framework/blob/master/springmvc/springMVC_04_exception/src/main/java/com/springMVC/exception/SysExceptionResolver.java)(使用请在配置文件中配置自定义异常处理器)
  - [拦截器](https://github.com/lxf-00/Framework/blob/master/springmvc/spring_05_interceptor/src/main/java/com/springMVC/interceptor/MyInterceptor1.java)[、配置拦截器](https://github.com/lxf-00/Framework/blob/master/springmvc/spring_05_interceptor/src/main/resources/springMVC.xml)
### 4. ssm 的整合
- [整体案例](https://github.com/lxf-00/Framework/tree/master/ssm_2)
- [整体pom](https://github.com/lxf-00/Framework/blob/master/ssm_2/pom.xml)
- [整体配置示意图](https://github.com/lxf-00/Framework/blob/master/ssm_2/ssm%E6%95%B4%E5%90%88%E7%A4%BA%E6%84%8F%E5%9B%BE.001.jpeg)
- 整合简单说明(github 图片无法正常显示预览，先占个位):
  - [加载配置文件、配置监听器](https://github.com/lxf-00/Framework/blob/master/ssm_2/ssm_2_web/src/main/webapp/WEB-INF/web.xml) ( 前提：配置好spring springmvc 各自的配置文件)
  - spring mybatis整合： 可将mybatis相关配置，配置到spring中，去除mybatis配置文件
  - [大体配置文件示例](https://github.com/lxf-00/Framework/blob/master/ssm_2/ssm_2_web/src/main/resources/applicationContext.xml)
  - [spring-security配置](https://github.com/lxf-00/Framework/blob/master/ssm_2/ssm_2_web/src/main/resources/spring-security.xml)[,示例](https://github.com/lxf-00/Framework/blob/master/ssm_2/ssm_2_service/src/main/java/com/lxf/service/impl/UserServiceImpl.java)

### 5. SpringBoot
- Spring Boot：搭建程序的脚手架。其最主要作用就是帮我们快速的构建庞大的spring项目，并且尽可能的减少一切xml配置，做到开箱即用，迅速上手，让我们关注与业务而非配置。
- 简单案例分析：
  - [起步依赖](https://github.com/lxf-00/Framework/blob/master/springboot_2/pom.xml)
  - [java配置: 主要靠java类和一些注解](https://github.com/lxf-00/Framework/blob/master/springboot_2/src/main/java/com/example/config/JdbcConfig.java)
- 热部署
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
```
  - 常用注解：
    - @Configuration: 声明一个类作为配置类，代替xml文件
    - @Bean：声明在方法上，将方法的返回值加入Bean容器，代替<bean>标签
    - @PropertySource：指定外部属性文件(不常用)
    - @Value： 属性注入(不常用)
  - springboot 属性注入
    - @ConfigurationProperties + @EnableConfigurationProperties + @Autowired
- 自动配置原理:
  - @SpringBootApplication -> SpringApplication.run()
- 整合springMVC
  - [修改端口](https://github.com/lxf-00/Framework/blob/master/springboot_2/src/main/resources/application.yml)
  - 访问静态资源
  - [自定义拦截器](https://github.com/lxf-00/Framework/blob/master/springboot_2/src/main/java/com/example/interceptor/Myinterceptor.java)[、添加拦截器](https://github.com/lxf-00/Framework/blob/master/springboot_2/src/main/java/com/example/config/MvcConfig.java)
- 整合jdbc和事务: 添加jdbc和mysql启动依赖,使用@Transactional 注解即可
- [整合连接池： 需要配置数据库相关信息](https://github.com/lxf-00/Framework/blob/master/springboot_2/src/main/resources/application.yml)
- 整合mybatis:
- 通用mapper(自带有mybatis, jdbc，可以只需配置 数据库启动依赖)
- Thymeleaf
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

默认前缀：classpath:templates/
默认后缀： .html
```

### 6. spirng
