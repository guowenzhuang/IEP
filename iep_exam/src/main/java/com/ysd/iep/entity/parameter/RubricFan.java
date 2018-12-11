package com.ysd.iep.entity.parameter;

import com.ysd.iep.entity.Rubric;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricFan {

    private Integer total;
    private List<Rubric> rubricList;


}
