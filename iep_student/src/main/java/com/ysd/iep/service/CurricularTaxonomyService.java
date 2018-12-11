package com.ysd.iep.service;


import com.ysd.iep.util.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("IEP-ADMIN")
public interface CurricularTaxonomyService {

    @RequestMapping("/depart/get")
    public Result getCurricularTaxonomy();
}
