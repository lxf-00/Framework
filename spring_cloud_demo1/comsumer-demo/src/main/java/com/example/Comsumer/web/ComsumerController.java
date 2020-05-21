package com.example.Comsumer.web;

import com.example.Comsumer.client.UserClient;
import com.example.Comsumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.hypermedia.DiscoveredResource;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/comsumer")
@DefaultProperties(defaultFallback = "defaultFallBack")
public class ComsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;
    // @Autowired
    //private RibbonLoadBalancerClient client;

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") int id){
        return userClient.queryById(id);
}


//     @GetMapping("{id}")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
//    })
//    public String queryById(@PathVariable("id") int id){
//        if( id %2 == 0){
//            throw new RuntimeException();
//        }
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

    public String defaultFallBack(){
        return "服务器拥挤，请稍后再试！";
    }

//    public String queryByIdFallBack(int id){
//        return "服务器拥挤，请稍后再试！";
//    }

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") int id){
//        // 根据服务id获取服务
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        // 从实例中获取ip port
//        // ServiceInstance instance = instances.get(0);
//        // ServiceInstance instance = client.choose("user-service");
//        // String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/" + String.valueOf(id);
//
//        String url = "http://user-service/user/" + id;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }
}
