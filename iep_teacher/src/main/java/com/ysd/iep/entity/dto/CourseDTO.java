package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class CourseDTO {
    private Integer courId;  //课程ID
    private String courName;
    private String courTeaid;
    private String courDepid;
    private String courPicurl;
    private Double courPrice;
    private Double courNocount;//
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
    private Integer courStudypeople;//报名人数
    private Integer Ext1;
    private String Ext2;
    private Integer countChaSum;
    private List<Integer> chaIds;

}
