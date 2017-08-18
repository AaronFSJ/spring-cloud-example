package com.aaron.controller;

import com.aaron.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aaron on 2017/8/7.
 */
@RestController
public class MovieController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 基础调用方法
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Long id){
//        return this.restTemplate.getForObject("http://localhost:8888/getUser/"+id,User.class);
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");//注册到eureka服务上的生产者的application.name
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getUser/"+id;
        logger.info(url);
        return this.restTemplate.getForObject(url,User.class);
    }

}
