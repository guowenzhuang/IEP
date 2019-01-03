package com.ysd.iep.entity.parameter;

import lombok.Data;

import java.util.Date;

/**
 * @author gaozhongye
 * @date 2018/12/23
 * 开始考试需要传递到后台数据
 */
@Data
public class BeginexamQuery {
    private String parerid;//卷子id
    private String studentid;//学生id

    private Date begintime;//开始时间
    private Integer examtime;//考试时长

}
