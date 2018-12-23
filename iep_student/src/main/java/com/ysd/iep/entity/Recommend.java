package com.ysd.iep.entity;

import lombok.Data;

@Data
public class Recommend {
    private String id;
    /**
     * 推荐课程id
     */
    private Integer coursetId;
    /**
     * 推荐位置id
     */
    private String positionId;
    /**
     * 权重
     */
    private Integer weight;
}
