package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Examrubric;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExamrubricFan {

    private Integer total;
    private List<Examrubric> page;

}
