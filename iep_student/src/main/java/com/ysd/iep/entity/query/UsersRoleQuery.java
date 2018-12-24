package com.ysd.iep.entity.query;

import lombok.Data;

@Data
public class UsersRoleQuery {

    /**
     * 用户姓名
     */
    private String name;
    private String roleName;
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
