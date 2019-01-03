package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试试卷表实体类
 */
@Data
@Entity
@Table(name = "examparper_tb")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Examparper {
    @Id
    @Column(name = "id", nullable = false, length = 50)
    private String id;//考试试卷id
    @Column(name = "Type",  length = 50)
    private String type;//考试类型
    @Column(name = "Title",  length = 200)
    private String title;//考试标题
    @Column(name = "Subject",  length = 50)
    private String subject;//考试科目
    @Column(name = "Duration", length = 20)
    private Integer duration;//考试时长
    @Column(name = "State",  length = 50)
    private String state;//考试状态(默认初始未开考)
    @Column(name = "Total",  length = 20)
    private Integer total;//卷子总分
    @Column(name = "Num",  length = 20)
    private Integer num;//考试试题数量
    @Column(name = "TecherId", length = 50)
    private String techerId;//教师id
    @Column(name = "createtime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;//试卷生成时间
    @Column(name = "Examtime")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date examtime;//开考时间
    @Column(name = "Radionum",  length = 20)
    private Integer radionum;//单选数量

    @Column(name = "Multiplenum",  length = 20)
    private Integer multiplenum;//多选数量
    @Column(name = "Fillnum",  length = 20)
    private Integer fillnum;//填空数量
    @Column(name = "Judgenum", length = 20)
    private Integer judgenum;//判断数量
    @Column(name = "passingScore", length = 20)
    private Integer passingScore;//及格分数
    @Column(name = "examshortesttime",  length = 20)
    private Integer examshortesttime;//考试最短可交卷时间

    //@JsonIgnore
    @OneToMany(mappedBy = "examparper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Examrubric> examrubricslist;//一张卷子可以有多到题干

}
