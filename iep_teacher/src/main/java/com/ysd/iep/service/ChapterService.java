package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.dto.Result;

public interface ChapterService {
	/**
	 * 查询章节
	 */
	public List<Chapters> querychapterTree(Integer courid);
	/**
	 * 新增章节
	 * @param chapters
	 * @return
	 */
	Result insertChapters(Chapters chapters);


}
