package com.ysd.iep.entity.parameter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gaozhongye
 * @date 2018/12/7
 * 条件查询试题的条件
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricQuery {
    /**
     * 可以根据:
     * 试题的类型
     * 试题的所属的课程(模糊查询)
     * 章节试题所在的课程的章节(课程选择之后可以选择章节)
     * 题干的内容模糊查询
     */
    private String rubric;
    private String type;
    private String course;
    private String section;


}
