package com.ysd.iep.entitySerch;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamParperSerch {
    private String subject;//考试科目
    private String title;//考试标题
    private String type;//考试类型
    private String state;//考试状态(默认初始未开考)
    private Integer total;//总分数
    private Integer duration;//考试时长
    private Integer examshortesttime;//最低交卷时间
    private Integer radionum;//单选题数量
    private Integer radionumresource;//单选题每题分数
    private Integer judgenum;//判断题数量
    private Integer judgenumresource;//判断题每题分数
    private Integer fillnum;//填空题数量
    private Integer fillnumresource;//填空题每题分数
    private Integer multiplenum;//多选题数量
    private Integer multiplenumresource;//多选题每题分数
    private String teacherId;//教师id
    private Integer passingScore;//及格分数
    private Integer page;
    private Integer rows;
    private Integer sectionId;//章节id
}
