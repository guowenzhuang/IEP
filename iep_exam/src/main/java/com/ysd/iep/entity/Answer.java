package com.ysd.iep.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author gaozhongye
 * @date 2018/12/6
 * 选项表实体类
 */
@Data
@Entity
@Table(name = "answer_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//选项id
    @Column(name = "Optiones", nullable = false, length = 50)
    private String optiones;//选项(ABCD)
    @Column(name = "Content", nullable = false, length = 50)
    private String content;//选项内容

    //@Column(name = "RubricId", nullable = false, length = 50)
    //private String RubricId;//题干id
    @JsonIgnore
    @ManyToOne(targetEntity = Rubric.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "Answer_Rubric_Id")
    private Rubric rubric;//答案所属的题干id


}
