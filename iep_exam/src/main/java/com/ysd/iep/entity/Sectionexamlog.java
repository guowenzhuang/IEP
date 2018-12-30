package com.ysd.iep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gaozhongye
 * @date 2018/12/30
 * 章节测试记录表实体类
 */

@Data
@Entity
@Table(name = "Sectionexamlog_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Sectionexamlog {

    @Id
    @Column(name = "Id", nullable = false, length = 50)
    private String id;
    @Column(name = "sectionexamparperId", nullable = false, length = 50)
    private String sectionexamparperid;
    @Column(name = "sectionexamrubricId", nullable = false, length = 50)
    private String sectionexamrubricid;
    @Column(name = "selectId", nullable = false, length = 50)
    private String selectid;
    @Column(name = "studentId", nullable = false, length = 50)
    private String studentid;
    @Column(name = "performance", nullable = false, length = 20)
    private Integer performance;
    @Column(name = "courseId", nullable = false, length = 20)
    private Integer courseid;
    @Column(name = "sectionId", nullable = false, length = 20)
    private Integer sectionid;


}
