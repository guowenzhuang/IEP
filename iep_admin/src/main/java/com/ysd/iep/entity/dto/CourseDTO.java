package com.ysd.iep.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class CourseDTO {
    /**
     * 课程id
     */
    private Integer courId;
    /**
     * 课程名称
     */
    private String courName;
    /**
     * 课程所属用户(教师)
     */
    private String courTeaid;
    /**
     * 院系id
     */
    private String courDepid;
    /**
     * 课程图片
     */
    private String courPicurl;
    /**
     * 课程路径
     */
    private Double courPrice;
    /**
     * 课程优惠
     */
    private Double courNocount;
    /**
     * 课程描述
     */
    private String courContent;
    /**
     * 课程详情
     */
    private String courDetails;
    /**
     * 浏览量
     */
    private Integer courPageview;
    /**
     * 评分标准
     */
    private String courScore;
    /**
     * 课程目标
     */
    private String courTarget;
    /**
     * 参考资料
     */
    private String courResources;
    /**
     * 预备知识
     */
    private String courPropaedeutics;
    /**
     * 是否上架
     */
    private String courIsputaway;
    /**
     * 课程评价
     */
    private Integer courCommentcount;

}
