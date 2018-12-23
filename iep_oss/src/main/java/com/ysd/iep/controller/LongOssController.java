package com.ysd.iep.controller;

import com.ysd.iep.bean.Result;
import com.ysd.iep.service.LongOssService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@RestController
@RequestMapping("/long")
public class LongOssController {
    @Autowired
    private LongOssService longOssService;

    @PostMapping("/longUploadFirst")
    public Result longUploadFirst(String path) {
        return Result.success(longOssService.longUploadFirst(path));
    }

    @PostMapping("/loadUploadConenet")
    public Result<String> loadUploadConenet(MultipartFile file, String uploadId, String path) throws IOException {
        return longOssService.loadUploadConenet(file, uploadId, path);
    }

    @PostMapping("/loadUploadEnd")
    public Result loadUploadEnd(String uploadId, String path) {
        return longOssService.loadUploadEnd(uploadId, path);
    }


}
