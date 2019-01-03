package com.ysd.iep.feign;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "IEP-STUDENT")
public interface StudentFrign {

    /**
     * 根据学分 学生id 修改学生表
     *
     * @param credits
     * @param sid
     * @return
     */
    @PutMapping("/stu/updateCredits")
    Result updateCredits(@RequestParam("credits") Integer credits, @RequestParam("sid") String sid);


}
