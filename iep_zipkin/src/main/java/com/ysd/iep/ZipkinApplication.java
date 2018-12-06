package com.ysd.iep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import zipkin2.server.internal.EnableZipkinServer;
import zipkin2.storage.mysql.v1.MySQLStorage;


import javax.sql.DataSource;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }



}
