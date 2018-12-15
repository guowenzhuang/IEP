package com.ysd.iep.entity.query;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class CourseQuery {
    /**
     * 课程名称
     */
    private String courName;
    /**
     * 排序字段
     */
    private String orderBy;
    /**
     * 第几页 条数  偏移量
     */
    private int page,rows,offsex;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if(this.rows!=0)
            this.offsex=(page-1)*rows;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        if(this.page!=0)
            this.offsex=(page-1)*rows;
    }

}
