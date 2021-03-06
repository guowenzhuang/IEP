package com.ysd.iep.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class Course {

    private Integer courId;  //课程ID
    private String courName;
    private String courTeaid;
    private String courDepid;
    private String courPicurl;
    private Double courPrice;
    private Double courNocount;
    private String courContent;
    private String courDetails;
    private Integer courPageview;//浏览量
    private String courScore;//评分标准
    private String courTarget;//课程目标
    private String courResources;//参考资料
    private String courPropaedeutics;//预备知识
    private String courIsputaway;//是否上架
    private String courOpentime;//开课时间
    private String courClasshour;//学时
    private Integer courCommentcount;//课程评价数量
    private Integer courStudypeople;
    private Integer countChaSum;
    private List<Integer> chaIds;


}
