package com.ysd.iep.feign;

import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient("IEP-ADMIN")
public interface CurricularFeign {
    @RequestMapping("/depart/get")
    Result getCurricularTaxonomy();
}
