package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试题干表实体类
 */
@Data
@Entity
@Table(name = "examrubric_tb")
@AllArgsConstructor
@Accessors(chain = true)
public class Examrubric {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//考试题干id
    @Column(name = "SectionId", nullable = true, length = 50)
    private String sectionId;//章节id
    @Column(name = "CourseId", nullable = true, length = 50)
    private Integer courseId;//课程id

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


    //@Column(name = "ExamparperId", nullable = false, length = 50)
    //private String ExamparperId;//考试试卷id

    @JsonIgnore
    @ManyToOne(targetEntity = Examparper.class)
    @JoinColumn(name = "examrubric_examparper_Id")
    private Examparper examparper;//多道题干属于一张试卷

    //@JsonIgnore
    @OneToMany(mappedBy = "examrubric", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Examanswer> examanswers;//考试答案集合


    public Examrubric(String id, String sectionId, Integer courseId, String answerId, String content, String trcherId, Integer score, String rubricttype) {
        this.id = id;
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.answerId = answerId;
        this.content = content;
        this.trcherId = trcherId;
        this.score = score;
        this.rubricttype = rubricttype;

    }

    public Examrubric() {
    }
}
