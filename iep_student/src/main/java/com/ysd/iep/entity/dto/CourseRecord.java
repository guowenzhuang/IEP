package com.ysd.iep.entity.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class CourseRecord {
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

    private Integer rid;//学习记录id
    private String sid;//学生id
    private Integer cid;//课程id
    private Integer chaid;//章节id
    private String watchtime;//视频观看时间
    private Integer credits;//学分
    private Date starttime;//学习开始的时间
    private String ext1;//预留字段
}
