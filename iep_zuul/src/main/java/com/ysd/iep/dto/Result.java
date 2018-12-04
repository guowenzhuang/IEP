package com.ysd.iep.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class Result {
    private boolean success;
    private Object message;
    private String remark;
}
