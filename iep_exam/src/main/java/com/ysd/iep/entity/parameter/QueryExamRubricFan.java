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

    private List<Examrubric> examrubricList;
    private String downtime;
    private Object parpercontent;
}
