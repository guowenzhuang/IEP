package com.ysd.iep.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * @author exam
 * @date 2018/12/6
 * 题干表实体类
 */
@Data
@Entity
@Table(name = "rubrictb")
@AllArgsConstructor
@NoArgsConstructor
public class Rubric {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String Id;//题干id
    @Column(name = "SectionId", nullable = false, length = 50)
    private String SectionId; //章节ID
    @Column(name = "CourseId", nullable = false, length = 50)
    private String CourseId; //课程id

    @Column(name = "Answer", nullable = false, length = 50)
    private String Answer;//答案
    @Column(name = "Content", nullable = false, length = 50)
    private String Content;//题干内容
    @Column(name = "TrcherId", nullable = false, length = 50)
    private String TrcherId;//教师id

    @Column(name = "Score", nullable = false, length = 20)
    private Integer Score;//分值
    @Column(name = "Rubricttype", nullable = false, length = 50)
    private String Rubricttype;//题干类型


}
