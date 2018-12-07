package com.ysd.iep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author exam
 * @date 2018/12/7
 * 章节测试表实体类
 */

@Data
@Entity
@Table(name = "Sectionexam_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Sectionexam {

    @Id
    @Column(name = "Id",nullable =false,length = 50)
    private String Id;//章节测试id
    @Column(name = "SectionId",nullable =false,length = 50)
    private String SectionId;//章节id
    @Column(name = "CourseId",nullable =false,length = 50)
    private String CourseId;//课程id
    @Column(name = "createtime")
    private Data createtime;//试卷生成时间





}
