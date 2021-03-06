package com.aaron.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaron on 2017/8/24.
 */
@RestController
@RefreshScope //运行期间动态调整配置
public class ConfigClientController {

    @Value("${profile}")
    private String profile;

    //spring.datasource.url
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @GetMapping("/profile")
    public String getProfile(){
        return this.profile;
    }

    @GetMapping("/getDatasource")
    public String getDatasource(){
        return this.dataSourceUrl;
    }


}
