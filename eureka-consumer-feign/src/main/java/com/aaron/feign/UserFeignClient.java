package com.aaron.feign;

import com.aaron.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aaron on 2017/8/18.
 * Feign的客户端接口定义，定义生产者
 */
@FeignClient("eureka-provider")//eureka-provider注册到eureka上的生产者的应用名称
public interface UserFeignClient {

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
