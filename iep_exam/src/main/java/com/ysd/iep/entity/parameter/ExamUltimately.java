package com.ysd.iep.entity.parameter;

import lombok.Data;

/**
 * @author gaozhongye
 * @date 2018/12/24
 * <p>
 * 最终考试结束(传参)
 */
@Data
public class ExamUltimately {
    /**
     * 需要的参数:
     * (1)考试学生的id
     * (2)考试试卷的id
     * (3)考生所选答案id
     * (根据考试试id将试卷的所有试题查询出来,
     * 从中单独取出来试题的题干中的答案id[answerId],
     * 遍历该id集合,使之与学生所选的答案id比较.
     * 在根据答案id的外键关系可以获取到考试试卷的id,
     * 再根据考试试卷id,对试题进行加分.)
     */
    private String studentId;
    private String examparperId;
    private String selectanswerId;
    private String examrubricId;
    private Integer score;
    
}
