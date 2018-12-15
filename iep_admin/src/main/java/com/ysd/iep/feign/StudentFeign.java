package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.CommentDTO;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-STUDENT")
public interface StudentFeign {

    /**
     * 新增学生
     * @param studentDTO
     * @return
     */
    @PostMapping("/stu/addStudent")
    Result<String> add(StudentDTO studentDTO);

    /**
     * 删除学生
     * @param sid
     * @return
     */
    @DeleteMapping("/stu/deleteStudent")
    Result<String> delete(@RequestParam("sid") String sid);

    /**
     * 分页按评论数量查找课程id
     * @param page
     * @param size
     * @param orderBy
     * @return
     */
    @GetMapping("/stu/queryOrder")
    Page<CommentDTO> queryOrder(@RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("orderBy") String orderBy);
}
