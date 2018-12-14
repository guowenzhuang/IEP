package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/8
 * 章节测试题干表实体类
 */


@Entity
@Table(name = "sectionexamrubric_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sectionexamrubric {

    @javax.persistence.Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//考试题干id
    @Column(name = "SectionId", nullable = true, length = 50)
    private String sectionId;//章节id
    @Column(name = "CourseId", nullable = true, length = 50)
    private String courseId;//课程id

    @Column(name = "AnswerId", nullable = false, length = 50)
    private String answerId;//答案id
    @Column(name = "Content", nullable = false, length = 200)
    private String content;//题目内容
    @Column(name = "TrcherId", nullable = true, length = 50)
    private String trcherId;//教师id
    @Column(name = "Score", nullable = false, length = 20)
    private Integer score;//分值
    @Column(name = "Rubricttype", nullable = false, length = 50)
    private String rubricttype;//题干类型(单选,多选,判断,填空)


    @ManyToOne(targetEntity = Sectionexamparper.class)
    @JoinColumn(name = "sectionexamrubric_sectionexamparper_Id")
    private Sectionexamparper sectionexamparper;//多道题干属于一张试卷

    //@JsonIgnore
    @OneToMany(mappedBy = "Sectionexamrubric", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sectionexamanswer> examanswers;//考试答案集合
}
