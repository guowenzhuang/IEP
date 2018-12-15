package com.ysd.iep.entity.parameter;

import lombok.Data;

@Data
public class UpdaterubricQuery {

    private String id;//修改的题的id
    private String answerid;//正确答案id(选择题id,填空题标准答案,判断题对错)
    private String rubric;//选择修改过的题干
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


    private String duoinputA;//多选答案
    private String duoinputB;
    private String duoinputC;
    private String duoinputD;
    private String duoinputupdate;//多选题干
    private String packrubric;//填空题干
    private String judgerubric;//判断题干
    private String duoanswerid;//多选答案id


    /**
     * params.append("duoinputA", this.duoinputA);//多选的修改答案
     *                 params.append("duoinputB", this.duoinputB);
     *                 params.append("duoinputA", this.duoinputC);
     *                 params.append("duoinputB", this.duoinputD);
     *                 params.append("duoinputupdate", this.duoinputupdate);
     *                 params.append("packrubric", this.packrubric);
     *                 params.append("judgerubric", this.judgerubric);
     *                 params.append("duoanswerid", this.duoform1 + this.duoform2 + this.duoform3 + this.duoform4);
     */


}
