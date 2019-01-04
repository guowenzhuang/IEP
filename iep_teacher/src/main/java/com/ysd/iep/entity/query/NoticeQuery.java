package com.ysd.iep.entity.query;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NoticeQuery {
	/**
	 * 公告id
	 */
	private Integer noId;
	
	/**
	 * 课程id(外键)
	 */
	private Integer noCourid;
	
	 /**
     * 公告创建开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp beginCreateTime;
    /**
     * 公告创建结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endCreateTime;
	
	/**
	 * 公告标题
	 */
	private String noTitle;
	
	
	private String noConten;
	
	/**
     * 排序字段
     */
    private String order;
	
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

	public Integer getNoId() {
		return noId;
	}

	public void setNoId(Integer noId) {
		this.noId = noId;
	}

	public Integer getNoCourid() {
		return noCourid;
	}

	public void setNoCourid(Integer noCourid) {
		this.noCourid = noCourid;
	}

	public Timestamp getBeginCreateTime() {
		return beginCreateTime;
	}

	public void setBeginCreateTime(Timestamp beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}

	public Timestamp getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Timestamp endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getNoTitle() {
		return noTitle;
	}

	public void setNoTitle(String noTitle) {
		this.noTitle = noTitle;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public NoticeQuery() {
		super();
	}

	public String getNoConten() {
		return noConten;
	}

	public void setNoConten(String noConten) {
		this.noConten = noConten;
	}

	public NoticeQuery(Integer noId, Integer noCourid, Timestamp beginCreateTime, Timestamp endCreateTime,
			String noTitle, String noConten, String order) {
		super();
		this.noId = noId;
		this.noCourid = noCourid;
		this.beginCreateTime = beginCreateTime;
		this.endCreateTime = endCreateTime;
		this.noTitle = noTitle;
		this.noConten = noConten;
		this.order = order;
	}

	@Override
	public String toString() {
		return "NoticeQuery [noId=" + noId + ", noCourid=" + noCourid + ", beginCreateTime=" + beginCreateTime
				+ ", endCreateTime=" + endCreateTime + ", noTitle=" + noTitle + ", noConten=" + noConten + ", order="
				+ order + "]";
	}

	
    
    

}
