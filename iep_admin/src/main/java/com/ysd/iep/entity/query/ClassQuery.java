package com.ysd.iep.entity.query;

import lombok.Data;

/**
 * 班级查询
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class ClassQuery {

    private String code;
    private String departmentId;
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
