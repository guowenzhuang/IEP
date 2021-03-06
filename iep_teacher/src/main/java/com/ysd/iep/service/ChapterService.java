package com.ysd.iep.service;

import java.util.List;

import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.Course;
import com.ysd.iep.entity.dto.Result;

public interface ChapterService {
	/**
	 * 根据Id查询父章节
	 * @param courid
	 * @return
	 */
	public List<Chapters> queryParentchapter(Integer courid);
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

	/**
	 * 根据章节id修改视频的路径和视频的时长
	 * @param chaId
	 */
	Result deleteChapters(Integer chaId);
  
    /**
     * 修改章节
     * @param chapters
     * @return
     */
    public Result updateCourse(Chapters chapters);
	/**
	 * 根据课程Id查询章节的总条数
	 * @param chaCourid
	 * @return
	 */
	Result queryCountById(Integer chaCourid);

    Chapters get(Integer id);

	/**
	 * 根据课程id判断是否有章节
	 * @param cid
	 * @return
	 */
    Result<String> findByCid(Integer cid);
}
