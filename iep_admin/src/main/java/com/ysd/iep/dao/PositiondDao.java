package com.ysd.iep.dao;

import com.ysd.iep.entity.po.PositionDB;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface PositiondDao extends BaseDao<PositionDB, String> {

    /**
     * 根据代码查询位置id
     * @param code
     * @return
     */
    @Query(value = "from PositionDB where code=:code")
    PositionDB getByCode(@Param("code") String code);

    @Query(value = "select p.id ,p.name from recommend r left join position p on r.positionId=p.id where r.coursetId=:courId",nativeQuery = true)
    List<Map> findNamesByCourId(@Param("courId") Integer courId);


}
