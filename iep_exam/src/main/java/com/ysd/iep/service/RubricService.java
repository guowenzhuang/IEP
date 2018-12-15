package com.ysd.iep.service;

import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.entity.parameter.UpdaterubricQuery;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 试题的 service层
 *
 * @author gaozhongye
 * @date 2018/12/6
 */

public interface RubricService {

    /**
     * 分页查询试题
     *
     * @return
     */
    Page<Rubric> queryUserByuserQuery(RubricQuery rubricquery, Integer page, Integer rows);

    /**
     * 删除试题
     *
     * @param id
     * @return
     */
    Object deleteredicbyid(String id);

    /**
     * 新增试题
     *
     * @param addrubricquery
     * @return
     */
    Object addrubric(AddrubricQuery addrubricquery);

    /**
     * 修改试题(三种试题)
     *
     * @param updaterubricquery
     * @return
     */
    Object updateredicbyid(UpdaterubricQuery updaterubricquery);


}
