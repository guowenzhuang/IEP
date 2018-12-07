package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试试卷表实体类
 */
@Data
@Entity
@Table(name = "examparpertb")
@AllArgsConstructor
@NoArgsConstructor
public class Examparper {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String Id;//考试试卷id
    @Column(name = "Type", nullable = false, length = 50)
    private String Type;//考试类型
    @Column(name = "Title", nullable = false, length = 50)
    private String Title;//考试标题

    @Column(name = "Subject", nullable = false, length = 50)
    private String Subject;//考试科目
    @Column(name = "Duration", nullable = false, length = 20)
    private Integer Duration;//考试时长
    @Column(name = "State", nullable = false, length = 50)
    private String State;//考试状态

    @Column(name = "Total", nullable = false, length = 20)
    private Integer Total;//卷子总分
    @Column(name = "Num", nullable = false, length = 20)
    private Integer Num;//考试试题数量
    @Column(name = "TecherId", nullable = false, length = 50)
    private String TecherId;//教师id

    @Column(name = "createtime")
    private Data createtime;//试卷生成时间
    @Column(name = "Examtime")
    private Data Examtime;//开考时间
    @Column(name = "Radionum", nullable = false, length = 20)
    private Integer Radionum;//单选数量

    @Column(name = "Multiplenum", nullable = false, length = 20)
    private Integer Multiplenum;//多选数量
    @Column(name = "Fillnum", nullable = false, length = 20)
    private Integer Fillnum;//填空数量
    @Column(name = "Judgenum", nullable = false, length = 20)
    private Integer Judgenum;//判断数量

    @Column(name = "Judgenum", nullable = false, length = 20)
    private Integer examshortesttime;//考试最短可交卷时间


    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "examrubric_examparper_tb", joinColumns = {@JoinColumn(name = "examparperId")}, inverseJoinColumns = {@JoinColumn(name = "examrubricid")})
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<Examrubric> roleSet = new HashSet<Examrubric>();//一张卷子可以有多到题干


}
