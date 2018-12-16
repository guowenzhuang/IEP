package com.ysd.iep.entity.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Integer cid;
    private Long sum;

    public CommentDTO(Integer cid, Long sum) {
        this.cid = cid;
        this.sum = sum;
    }
}