package com.ysd.iep.controller;

import com.ysd.iep.entity.StudentPart;
import com.ysd.iep.entity.StudentPartCid;
import com.ysd.iep.service.StudentPartService;
import com.ysd.iep.service.TeacherService;
import com.ysd.iep.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * @Description:
 * @ClassName: StudentPartController.java
 * @author Liuyalong
 * @Date 2018年12月13日
 * @Email 1611549726@qq.com
 */

@RestController
@RequestMapping("/studentPart")
public class StudentPartController {

	@Autowired
	private StudentPartService s;

	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 根据学生id查询报名表返回课程id集合
	 * @param sid
	 * @return
	 */
	@GetMapping("/query")
	public Object queryStudentPart(@RequestParam("sid")String sid) {
		List<StudentPartCid> cidList=s.queryStudentPart(sid);	
		return cidList;
		
	}
	/**
	 * http://127.0.0.1:80/api/student/studentPart/querypeople
	 * 报名此课程的人数
	 * @param cid
	 * @return
	 */
	@GetMapping("/querypeople")
	public Integer querypeople(@RequestParam("cid")Integer cid) {
		return s.count(cid);
	}

	/**
	 * 报名课程
	 * @param courId
	 * @param sid    http://127.0.0.1:80/api/student/studentPart/add
	 */
	@PostMapping("/add")
	public Object add(@RequestParam("courId")Integer courId,@RequestParam("sid")String sid) {	
		try {
			s.add(courId,sid);
			teacherService.updateStudypeople(courId);
			return new Result<String>(true, "报名成功");
		} catch (Exception e) {
			return new Result<String>(false, "报名失败");
		}
		
	}
	
    /**
     * 
     * @param courId
     * @param sid
     * @return
     */
	@DeleteMapping("/detele")
	public Object detele(@RequestParam("courId")Integer courId,@RequestParam("sid") String sid) {
		StudentPart studentPart2 = new StudentPart();
		studentPart2.setCid(courId);
		studentPart2.setSid(sid);
		try {
			s.delete(studentPart2);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			return new Result(false, "删除失败");
		}
	}

}
