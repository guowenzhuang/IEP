package com.ysd.iep.controller;

import com.ysd.iep.bean.Result;
import com.ysd.iep.service.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
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
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Result<String> uploadFile(MultipartFile file,String path) {
        try {
            if (null != file) {
                String filename = file.getOriginalFilename();
                if (!"".equals(filename.trim())) {
                    String url = ossService.upload(file,path);
                    return Result.success(url);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
        return Result.error("文件为空");
    }

}
