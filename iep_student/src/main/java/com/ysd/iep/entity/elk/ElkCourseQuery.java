package com.ysd.iep.entity.elk;

import lombok.Data;

@Data
public class ElkCourseQuery {
    private String value;
    private Integer page;
    private Integer size;
    private String orderby;//排序
    private String conditions;//条件

}
