package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author gaozhongye
 * @date 2018/12/8
 * 章节测试选项表实体类
 */


@Entity
@Data
@Table(name = "Sectionexamanswer_tb")
public class Sectionexamanswer {
    @javax.persistence.Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//选项id
    @Column(name = "Optiones", nullable = false, length = 50)
    private String optiones;//选项(ABCD)
    @Column(name = "Content", nullable = false, length = 50)
    private String content;//选项内容

    //@Column(name = "RubricId", nullable = false, length = 50)
    //private String RubricId;//考试题干id
    @JsonIgnore
    @ManyToOne(targetEntity = Sectionexamrubric.class)
    @JoinColumn(name = "sectionexamanswer_sectionexamrubric_id")
    private Sectionexamrubric Sectionexamrubric;//答案所属的考试题干id

    public Sectionexamanswer(String id, String optiones, String content) {
        this.id = id;
        this.optiones = optiones;
        this.content = content;
    }
}
