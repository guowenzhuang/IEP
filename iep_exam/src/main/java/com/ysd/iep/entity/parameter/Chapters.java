package com.ysd.iep.entity.parameter;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class Chapters implements Serializable {
    private Integer chaId;
    private Integer chaParentid;
    private String chaName;
    private String chaPpturl;
    private String chaDocurl;//章节文档地址
    private Integer chaCourid;
    private String chaType;
    private String chaViurl;
    private String chalastModified;
    private String chaTime;//视频时长
    private String chaSize;
    private List<Chapters> children;
    private Integer Ext1;
    private String Ext2;
}
