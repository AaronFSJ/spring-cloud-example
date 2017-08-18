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
        String url = "http://eureka-provider/getUser/"+id;
        logger.info(url);
        return this.restTemplate.getForObject(url,User.class);
    }

}
