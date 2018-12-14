package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.CourceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-TEACKER")
public interface TeacherFeign {

/*    @PostMapping("")
    List<CourceDTO> findCourseById(@RequestParam("courId") String courId);*/
}
