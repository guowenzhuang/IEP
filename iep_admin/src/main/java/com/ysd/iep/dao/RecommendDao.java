package com.ysd.iep.dao;

import com.ysd.iep.entity.po.Recommend;
import com.ysd.iep.entity.po.RolesDB;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface RecommendDao extends BaseDao<Recommend, String> {

    /**
     * 根据位置id查询所有的推荐课程
     * @param position
     * @return
     */
    @Query(value = "select * from recommend where positionId=:positionId order by weight desc ",nativeQuery = true)
    List<Recommend> getByPositionId(@Param("positionId") String position);



}
