package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/6
 * 题干表实体类(对应Answer表)
 */
@Data
@Entity
@Table(name = "rubric_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Rubric {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//题干id
    @Column(name = "SectionId", nullable = true, length = 50)
    private String sectionId; //章节ID
    @Column(name = "CourseId", nullable = true, length = 50)
    private String sourseId;//课程id

    @Column(name = "AnswerId", nullable = false, length = 50)
    private String answerId;//答案id
    @Column(name = "Content", nullable = false, length = 50)
    private String content;//题干内容
    @Column(name = "TrcherId", nullable = true, length = 50)
    private String trcherId;//教师id

    @Column(name = "Score", nullable = true, length = 20)
    private Integer score;//分值
    @Column(name = "Rubricttype", nullable = false, length = 50)
    private String rubricttype;//题干类型(单选,多选,判断,填空)

    //@JsonIgnore
    @OneToMany(mappedBy = "rubric", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Answer> answer;//答案集合

}
