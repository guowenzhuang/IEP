package com.ysd.iep.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantProperties{
    @Value("${spring.oss.endpoint}")
    public static String SPRING_OSS_ENDPOINT;
    @Value("${spring.oss.keyid}")
    public static String SPRING_OSS_ACCESS_KEY_ID;
    @Value("${spring.oss.keysecret}")
    public static String SPRING_OSS_ACCESS_KEY_SECRET;
    @Value("${spring.oss.bucketname1}")
    public static String SPRING_OSS_BUCKET_NAME1;
}
