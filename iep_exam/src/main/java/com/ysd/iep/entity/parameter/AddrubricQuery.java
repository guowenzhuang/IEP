package com.ysd.iep.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddrubricQuery {

    private String answerid;
    private String addrubric;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    private String Aid;
    private String Bid;
    private String Cid;
    private String Did;


    private String rubrictype;
    private String userid;
    private Integer course;
    private Integer score;
    private String parperid;
}
