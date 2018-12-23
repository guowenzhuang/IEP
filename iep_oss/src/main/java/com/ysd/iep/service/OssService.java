package com.ysd.iep.service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.ysd.iep.bean.ConstantProperties;
import com.ysd.iep.bean.Result;
import com.ysd.iep.config.MyOSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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


    protected MyOSSClient getClient(){
        return new MyOSSClient(ConstantProperties.SPRING_OSS_ENDPOINT,
                ConstantProperties.SPRING_OSS_ACCESS_KEY_ID,
                ConstantProperties.SPRING_OSS_ACCESS_KEY_SECRET);
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
            if(path.startsWith("/") || path.startsWith("\\")){
                path=path.substring(1);
            }
            PutObjectResult putObjectResult=ossClient.putObject(ConstantProperties.SPRING_OSS_BUCKET_NAME,
                    path, file.getInputStream());
            /**
             * 过期时间为一小时
             */
            Date expiration = new Date(System.currentTimeMillis()+ 3600 * 1000);
            URL url = ossClient.generatePresignedUrl(ConstantProperties.SPRING_OSS_BUCKET_NAME, path,expiration);
            return url.toString();
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
    public URL getUrl(String path){
        System.out.println(path);
        MyOSSClient ossClient = getClient();
        // 设置过期时间。
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000*2);
        // 生成签名URL（HTTP GET请求）。
        URL signedUrl = ossClient .generatePresignedUrl(ConstantProperties.SPRING_OSS_BUCKET_NAME, path,expiration);
        return signedUrl;
    }
    /**
     * 文件下载
     * @param path
     * @return
     */
    public  InputStream download (String path){
        log.info("=========>OSS文件下载开始：" + path);
        OSSClient ossClient =getClient();
        try {
            OSSObject ossObject = ossClient.getObject(ConstantProperties.SPRING_OSS_BUCKET_NAME, path);
            InputStream inputStream=ossObject.getObjectContent();
            return inputStream;
        }catch (OSSException oe) {
            log.error(oe.getMessage());
        } catch (ClientException ce) {
            log.error(ce.getMessage());
        } finally { //关闭
            ossClient.shutdown();
        }
        return null;
    }


}

