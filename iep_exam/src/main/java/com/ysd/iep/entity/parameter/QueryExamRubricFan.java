package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Examrubric;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/24
 * 进入考试显示试卷的返回值实体类
 */
@Data
@AllArgsConstructor
public class QueryExamRubricFan {
    /**
     * 单选
     */
    private List<Examrubric> radiorubricList;
    /**
     * 多选
     */
    private List<Examrubric> duorubricList;
    /**
     * 填空题
     */
    private List<Examrubric> packrubricList;
    /**
     * 判断题
     */
    private List<Examrubric> judgerubricList;
    private long downtime;
    private Object parpercontent;
}
