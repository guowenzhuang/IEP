package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 章节测试表实体类
 */

@Data
@Entity
@Table(name = "sectionexamparper_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Sectionexamparper {

    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String Id;//章节测试id
    @Column(name = "SectionId", nullable = false, length = 50)
    private String SectionId;//章节id
    @Column(name = "CourseId", nullable = false, length = 50)
    private String CourseId;//课程id
    @Column(name = "createtime")
    private Date createtime;//试卷生成时间

    //@JsonIgnore
    @OneToMany(mappedBy = "sectionexamparper", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sectionexamrubric> sectionexamrubricslist;//一张卷子可以有多到题干(考试试卷)


}
