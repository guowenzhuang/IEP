package com.ysd.iep.dao;

import com.ysd.iep.entity.po.Position;
import com.ysd.iep.entity.po.Recommend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface PositiondDao extends BaseDao<Position, String> {

    /**
     * 根据代码查询位置id
     * @param code
     * @return
     */
    @Query(value = "select id from Position where code=:code")
    String getByCode(@Param("code") String code);

}
