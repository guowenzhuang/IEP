package com.ysd.iep.feign;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.po.PermissionDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@FeignClient("IEP-BBS")
public interface BbsFeign {
    /**
     * 收集权限
     * @return
     */
    @GetMapping("/generalTright/collectPermission")
    Result<List<PermissionDB>> collectPermission();
}
