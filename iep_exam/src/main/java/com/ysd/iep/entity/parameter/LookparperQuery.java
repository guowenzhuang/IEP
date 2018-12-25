package com.ysd.iep.entity.parameter;

import lombok.Data;

/**
 * @author gaozhongye
 * @date 2018/12/19
 * 显示试卷需要参数实体类
 */
@Data
public class LookparperQuery {
    private String content;
    private Integer index; //试题编号
    private String answer;//正确答案
    /*
        private String answerid;//正确答案id(因为填空是答案,判断是对错,所以需要此字段)
    */
    private String answerA;//答案内容
    private String answerB;
    private String answerC;
    private String answerD;
    private String rubrictype;//试题类型
    private Integer score;//题的分数
    private boolean seen;

    private String selectanswer;//学生所选的答案


}
