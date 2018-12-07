package com.ysd.iep.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 * @author exam
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
    private String Id;//成绩表id
    private String StudentId;//学生id
    private Integer Total;//总分
    private String parperId;//考试试卷id(章节测试试卷id)


}
