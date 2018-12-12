package com.ysd.iep.entitySerch;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamParperSerch {
    private String Subject;//考试科目
    private String Title;//考试标题
    private String Type;//考试类型
    private String State;//考试状态(默认初始未开考)
    private Integer page;
    private Integer rows;
}
