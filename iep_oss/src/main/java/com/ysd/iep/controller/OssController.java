package com.ysd.iep.controller;

import com.ysd.iep.bean.FileInfo;
import com.ysd.iep.bean.Result;
import com.ysd.iep.service.OssService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Api(value="/oss", tags="文件上传API")
@RestController
@Slf4j
public class OssController {
    @Autowired
    private OssService ossService;

    /**
     * 文件上传
     * @param file  文件
     * @param path  上传路径
     * @return
     */
    @PostMapping(value = "/upload")
    public Result<FileInfo> uploadFile(MultipartFile file, String path) {
        try {
            if (null != file) {
                String filename = file.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    return ossService.upload(file,path);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new Result<>(false,new FileInfo());
        }
        return new Result<>(false,new FileInfo());
    }

    @GetMapping("/download")
    public InputStream downloadFile(String path){
        return ossService.download(path);
    }
    @GetMapping("/getUrl")
    public URL getUrl(String path){
        return ossService.getUrl(path);
    }
}
