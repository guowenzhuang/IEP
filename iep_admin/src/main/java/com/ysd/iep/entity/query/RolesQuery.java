package com.ysd.iep.entity.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * 角色查询实体类
 */
@Data
@Accessors(chain = true)
public class RolesQuery {
    /**
     * 角色名称
     */
    private String name;
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
