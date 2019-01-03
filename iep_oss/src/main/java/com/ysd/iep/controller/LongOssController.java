package com.ysd.iep.controller;

import com.ysd.iep.bean.ConstantProperties;
import com.ysd.iep.bean.FileInfo;
import com.ysd.iep.bean.Result;
import com.ysd.iep.service.LongOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value="/long", tags="大文件上传API")
@RestController
@RequestMapping("/long")
public class LongOssController {
    @Autowired
    private LongOssService longOssService;

    @ApiOperation("分片首次上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path",value = "首次上传的路径",required = true,dataType = "String")
    })
    @PostMapping("/longUploadFirst")
    public Result longUploadFirst(String path) {
        return Result.success(longOssService.longUploadFirst(path));
    }

    @ApiOperation("上传文件内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "上传的文件",required = true),
            @ApiImplicitParam(name = "uploadId",value = "上传的唯一id",required = true,dataType = "String"),
            @ApiImplicitParam(name = "path",value = "上传的路径",required = true,dataType = "String")
    })
    @PostMapping("/loadUploadConenet")
    public Result<String> loadUploadConenet(MultipartFile file, String uploadId, String path) throws IOException {
        return longOssService.loadUploadConenet(file, uploadId, path);
    }

    @ApiOperation("上传完成开始合并文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uploadId",value = "上传的唯一id",required = true,dataType = "String"),
            @ApiImplicitParam(name = "path",value = "上传的路径",required = true,dataType = "String")
    })
    @PostMapping("/loadUploadEnd")
    public Result loadUploadEnd(String uploadId, String path) {
        Result<FileInfo> upload = longOssService.loadUploadEnd(uploadId, path);
        FileInfo fileInfo=upload.getMessage();
        fileInfo.setPath(ConstantProperties.PATH_PREFIX+fileInfo.getPath());
        return upload;
    }


}
