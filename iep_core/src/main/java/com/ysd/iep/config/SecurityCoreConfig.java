package com.ysd.iep.config;

import com.ysd.iep.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Configuration
//开启属性读取
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
