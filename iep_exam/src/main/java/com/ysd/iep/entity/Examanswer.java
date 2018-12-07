package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 考试选项表实体类
 */
@Data
@Entity
@Table(name = "examanswer_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Examanswer {

    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String Id;//选项id
    @Column(name = "Option", nullable = false, length = 50)
    private String Option;//选项(ABCD)
    @Column(name = "Content", nullable = false, length = 50)
    private String Content;//选项内容

    //@Column(name = "RubricId", nullable = false, length = 50)
    //private String RubricId;//考试题干id
    @JsonIgnore
    @ManyToOne(targetEntity = Examrubric.class)
    @JoinColumn(name = "examanswer_rubric_id")
    private Examrubric examrubric;//答案所属的考试题干id


}
