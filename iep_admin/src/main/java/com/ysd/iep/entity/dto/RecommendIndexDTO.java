package com.ysd.iep.entity.dto;

import com.ysd.iep.entity.po.RecommendDB;
import lombok.Data;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class RecommendIndexDTO {
    private List<RecommendDB> recommendDB001;
    private List<RecommendDB> recommendDB002;
}
