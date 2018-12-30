package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Sectionexamrubric;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuerysectionsFan {

    /**
     * 单选
     */
    private List<Sectionexamrubric> radiorubricList;
    /**
     * 多选
     */
    private List<Sectionexamrubric> duorubricList;
    /**
     * 填空题
     */
    private List<Sectionexamrubric> packrubricList;
    /**
     * 判断题
     */
    private List<Sectionexamrubric> judgerubricList;
    private long downtime;
    private Object parpercontent;
}
