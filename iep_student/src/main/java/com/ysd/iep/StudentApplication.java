package com.ysd.iep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class,args);
    }
    @RequestMapping("/we")
    public String we(){
        return "我是飞哥";
    }
}
