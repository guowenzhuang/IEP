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
    @Column(name = "Id", nullable = false, length = 20)
    private Integer Id;//选项id
    @Column(name = "Option", nullable = false, length = 50)
    private String Option;//选项(ABCD)
    @Column(name = "Content", nullable = false, length = 50)
    private String Content;//选项内容

    //@Column(name = "RubricId", nullable = false, length = 50)
    //private String RubricId;//题干id
    @JsonIgnore
    @ManyToOne(targetEntity = Rubric.class)
    @JoinColumn(name = "answer_rubric_id")
    private Rubric rubric;//答案所属的题干id


}
