package com.ysd.iep.entity.parameter;

import lombok.Data;

@Data
public class UpdaterubricQuery {

    private String id;//修改的题的id
    private String answerid;//正确答案id(选择题id,填空题标准答案,判断题对错)
    private String rubric;//修改过的题干
    private String answerA;//修改过的答案A
    private String answerB;
    private String answerC;
    private String answerD;
    private String Aid;//修改过的答案A
    private String Bid;
    private String Cid;
    private String Did;
    private String xzanswer;//选择正确答案选项(ABCD)
    private String tkanswer;//填空正确答案选项(String)
    private String pdanswer;//判断正确答案选项(true,false)
    private String type;//试题的类型
    private Object list;


}
