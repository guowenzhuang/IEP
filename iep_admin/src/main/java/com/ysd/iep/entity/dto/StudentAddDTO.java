package com.ysd.iep.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class StudentAddDTO {
    private String sid;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生身份证号
     */
    private String card;
    /**
     * 所属班级id
     */
    private String cid;
    private String code;
}
