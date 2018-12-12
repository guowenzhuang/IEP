package com.ysd.iep.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 成绩表实体类
 */

@Entity
@Data
@Table(name = "performance_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Performance {
    @Id
    @Column(name = "Id",nullable =false ,length = 50)
    private String id;//成绩表id
    @Column(name = "StudentId",nullable =false ,length = 50)
    private String studentId;//学生id
    @Column(name = "Total",nullable =false ,length = 20)
    private Integer total;//总分
    @Column(name = "parperId",nullable =false ,length = 50)
    private String parperId;//考试试卷id(章节测试试卷id)


}
