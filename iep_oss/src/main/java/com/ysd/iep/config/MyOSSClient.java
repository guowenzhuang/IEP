package com.ysd.iep.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.ysd.iep.bean.ConstantProperties;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class MyOSSClient extends OSSClient implements Serializable {
    public MyOSSClient(){
        super(ConstantProperties.SPRING_OSS_ENDPOINT,
                ConstantProperties.SPRING_OSS_ACCESS_KEY_ID,
                ConstantProperties.SPRING_OSS_ACCESS_KEY_SECRET);

    }
    public MyOSSClient(String endpoint, String accessKeyId, String secretAccessKey) {
        super(endpoint, new DefaultCredentialProvider(accessKeyId, secretAccessKey), null);
    }
}
