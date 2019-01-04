package com.ysd.iep.entity.query;

import lombok.Data;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Data
public class CourseQuery {
    /**
     * 院系Id
     */
    private String courDepid;
    /**
     * 排序字段
     */
    private String orderBy;

    private String courName;
    /**
     * 第几页 条数  偏移量
     */
    private int page,pageSize,offsex;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if(this.pageSize!=0)
            this.offsex=(page-1)*pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if(this.page!=0)
            this.offsex=(page-1)*pageSize;
    }

}
