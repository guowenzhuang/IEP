package com.ysd.iep.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEr {
    private boolean success;
    private String message;
    private Object remark;
    private Object remark2;
}
