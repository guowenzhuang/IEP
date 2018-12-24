package com.ysd.iep.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class FileInfo {
    private String path;
    private Long length;
    private Date lastDate;
}
