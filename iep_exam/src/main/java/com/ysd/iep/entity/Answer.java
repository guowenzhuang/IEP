package com.ysd.iep.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author exam
 * @date 2018/12/6
 * 选项表实体类
 */
@Data
@Entity
@Table(name = "answertb")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @Column(name = "Id", nullable = false, length = 20)
    private Integer Id;
    @Column(name = "Option", nullable = false, length = 50)
    private String Option;
    @Column(name = "Content", nullable = false, length = 50)
    private String Content;
    @Column(name = "RubricId", nullable = false, length = 50)
    private String RubricId;

}
