package com.ysd.iep.service;

import com.aliyun.oss.model.*;
import com.ysd.iep.bean.ConstantProperties;
import com.ysd.iep.bean.FileInfo;
import com.ysd.iep.bean.Result;
import com.ysd.iep.config.MyOSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * 大文件上传
 *
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
@Slf4j
public class LongOssService {
    @Autowired
    private OssService ossService;
    static final long MB = 1024 * 1024L;
    static short maxFp = 1;
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 准备大文件上传
     *
     * @return 文件唯一标识
     */
    public String longUploadFirst(String path) {
        log.info("大文件上传开始");
        MyOSSClient ossClient = ossService.getClient();
        //生成路径

        /* 步骤1：初始化一个分片上传事件。
         */
        InitiateMultipartUploadRequest request = new InitiateMultipartUploadRequest(ConstantProperties.SPRING_OSS_BUCKET_NAME, path);
        InitiateMultipartUploadResult result = ossClient.initiateMultipartUpload(request);
        // 返回uploadId，它是分片上传事件的唯一标
        // 您可以根据这个ID来发起相关的操作，如取消分片上传、查询分片上传等。
        String uploadId = result.getUploadId();
        List<PartETag> partETags = new ArrayList<PartETag>();
        redisTemplate.opsForValue().set(uploadId, partETags);
        ossClient.shutdown();
        return uploadId;
    }

    /**
     * 分片上传内容
     *
     * @param file     文件
     * @param uploadId 封面
     * @param path
     * @return
     * @throws IOException
     */
    public Result<String> loadUploadConenet(MultipartFile file, String uploadId, String path) throws IOException {
        System.out.println(" file.getOriginalFilename()=>" + file.getOriginalFilename());
        System.out.println(" file.name()=>" + file.getName());
        System.out.println(" file.getContentType()" + file.getContentType());
        MyOSSClient ossClient = ossService.getClient();
        if (file.getSize() / MB > maxFp) {
            return Result.error("分片大小不能超过1MB");
        }
        List<PartETag> partETags = (List<PartETag>) redisTemplate.opsForValue().get(uploadId);
        if (partETags.size() + 1 < 1 || partETags.size() + 1 > 10000) {
            return Result.error("分片号为1-10000");
        }
        log.info("上传第{}个分片开始上传", partETags.size() + 1);
        UploadPartRequest uploadPartRequest = new UploadPartRequest();
        uploadPartRequest.setBucketName(ConstantProperties.SPRING_OSS_BUCKET_NAME);
        uploadPartRequest.setKey(path);
        uploadPartRequest.setUploadId(uploadId);
        uploadPartRequest.setInputStream(file.getInputStream());
        uploadPartRequest.setPartSize(file.getSize());
        uploadPartRequest.setPartNumber(partETags.size() + 1);
        UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);
        PartETag partETag = uploadPartResult.getPartETag();
        partETags.add(partETag);
        redisTemplate.opsForValue().set(uploadId, partETags);
        ossClient.shutdown();
        log.info("第{}个分片上传结束", partETags.size() + 1);
        return Result.success(null);
    }

    /**
     * 合成提交
     *
     * @param uploadId
     * @param path
     * @return
     */
    public Result loadUploadEnd(String uploadId, String path) {
        MyOSSClient ossClient = ossService.getClient();
        List<PartETag> partETags = (List<PartETag>) redisTemplate.opsForValue().get(uploadId);
        Collections.sort(partETags, new Comparator<PartETag>() {
            public int compare(PartETag p1, PartETag p2) {
                return p1.getPartNumber() - p2.getPartNumber();
            }
        });
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                new CompleteMultipartUploadRequest(ConstantProperties.SPRING_OSS_BUCKET_NAME, path, uploadId, partETags);
        CompleteMultipartUploadResult result = ossClient.completeMultipartUpload(completeMultipartUploadRequest);
        // 关闭OSSClient
        FileInfo info=getInfo(path,ossClient);
        ossClient.shutdown();
        //删除redis
        redisTemplate.delete(uploadId);
        return new Result(true,info);
    }

    private FileInfo getInfo(String path, MyOSSClient ossClient) {
            ObjectMetadata metadata = ossClient.getObjectMetadata(ConstantProperties.SPRING_OSS_BUCKET_NAME, path);
            System.out.println();
            FileInfo info=new FileInfo();
            info.setLength(metadata.getContentLength());
            info.setLastDate(metadata.getLastModified());
            info.setLastDate(metadata.getLastModified());
            info.setPath(path);
            return info;
    }


}
