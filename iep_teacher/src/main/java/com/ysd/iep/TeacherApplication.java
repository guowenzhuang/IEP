package com.ysd.iep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@SpringBootApplication
@EnableEurekaClient
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class,args);
    }
}

