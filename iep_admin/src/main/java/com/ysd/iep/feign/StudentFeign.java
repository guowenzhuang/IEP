package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-STUDENT")
public interface StudentFeign {

    @PostMapping("/stu/addStudent")
    Result<String> add(StudentDTO studentDTO);

    @DeleteMapping("/stu/deleteStudent")
    Result<String> delete(@RequestParam("sid") String sid);
}
