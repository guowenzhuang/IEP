package com.ysd.iep.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.ysd.iep.bean.ConstantProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@Slf4j
public class OssService {

    public OSSClient getClient(){
        return new OSSClient(ConstantProperties.SPRING_OSS_ENDPOINT, ConstantProperties.SPRING_OSS_ACCESS_KEY_ID, ConstantProperties.SPRING_OSS_ACCESS_KEY_SECRET);
    }
    /**
     * 文件上传
     * @param file
     * @return
     */
    public String upload(MultipartFile file, String path) {
        log.info("=========>OSS文件上传开始：" + path);
        if (null == file) {
            return null;
        }
        OSSClient ossClient =getClient();
        try {
            PutObjectResult putObjectResult=ossClient.putObject(ConstantProperties.SPRING_OSS_BUCKET_NAME1,
                    path, file.getInputStream());
        } catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally { //关闭
            ossClient.shutdown();
        }
        return null;
    }

    public  String down(){
        return null;
    }


}

