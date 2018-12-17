package com.ysd.iep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class Examanswer {

    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;//选项id
    @Column(name = "Optiones", nullable = false, length = 50)
    private String optiones;//选项(ABCD)
    @Column(name = "Content", nullable = false, length = 50)
    private String content;//选项内容
    //@Column(name = "RubricId", nullable = false, length = 50)
    //private String RubricId;//考试题干id
    @JsonIgnore
    @ManyToOne(targetEntity = Examrubric.class)
    @JoinColumn(name = "examanswer_examrubric_id")
    private Examrubric examrubric;//答案所属的考试题干id

    public Examanswer(String id, String optiones, String content) {
        this.id = id;
        this.optiones = optiones;
        this.content = content;
    }

    public Examanswer() {
    }
}
