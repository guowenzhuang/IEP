package com.ysd.iep.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private boolean success;
    private Object message;
    private String remark;


}
