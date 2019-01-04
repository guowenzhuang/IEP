package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.*;
import com.ysd.iep.entity.po.PermissionDB;
import com.ysd.iep.util.Tright;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-STUDENT")
public interface StudentFeign {

    /**
     * 收集权限
     * @return
     */
    @GetMapping("/generalTright/collectPermission")
    Result<List<PermissionDB>> collectPermission();

    /**
     * 设置角色新增学生
     * @param studentDTO
     * @return
     */
    @PostMapping("/stu/addStudent")
    Result<String> add(StudentDTO studentDTO);

    /**
     * 新增学生
     * @param studentAddDTO
     * @return
     */
    @PostMapping("/stu/addStudent")
    Result<String> add(StudentAddDTO studentAddDTO);

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

    /**
     * 根据学生id 批量查询学生
     * @param ids
     * @return
     */
    @GetMapping("/stu/getByIds")
    Result<List<UsersStuDTO>> getByIds(@RequestParam("ids") String ids);
}
