package com.ysd.iep.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "rubrictb")
public class Rubric {
    @Id
    private String Id;//题干id

    private String SectionId; //章节id

    private String CourseId; //课程id

    private String Answer;//答案

    private String Content;//题干内容

    private String TrcherId;//教师id

    private String Score;//分值

    private String Rubricttype;//题干类型




}
