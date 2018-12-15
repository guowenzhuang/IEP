package com.ysd.iep.entity.courcePaging;

import com.ysd.iep.entity.dto.CourceDTO;
import com.ysd.iep.entity.vo.PagingResult;
import org.springframework.data.domain.Page;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface CourceState {
    /**
     * 分页查询课程
     * @param page
     * @param rows
     * @return
     */
    PagingResult<CourceDTO> pagingCource(Integer page, Integer rows);
}
