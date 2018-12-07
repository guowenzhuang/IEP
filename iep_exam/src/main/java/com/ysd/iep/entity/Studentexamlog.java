package com.ysd.iep.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author  gaozhognye
 * @date 2018/12/7
 * 考试记录表实体类
 */
@Data
@Entity
@Table(name = "answer_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Studentexamlog {
    @Id
    @Column(name = "Id",nullable = false,length = 50)
    private String Id;//考试记录表id
    @Column(name = "StudentId",nullable = false,length = 50)
    private String StudentId;//学生id
    @Column(name = "SelectId",nullable = false,length = 50)
    private String SelectId;//学生所选选项id

    @Column(name = "ExamparperId",nullable = false,length = 50)
    private String ExamparperId;//考试试卷id
    @Column(name = "performance",nullable = false,length = 50)
    private String performance;//测试题成绩
    @Column(name = "ExamrubricId",nullable = false,length = 50)
    private String ExamrubricId;//考试题干id



}
