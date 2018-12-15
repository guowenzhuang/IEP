package com.ysd.iep.entity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
@Accessors(chain = true)
public class PagingResult<T> {
    private long total;
    private List<T> rows;
}