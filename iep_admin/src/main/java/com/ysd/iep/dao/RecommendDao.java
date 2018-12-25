package com.ysd.iep.dao;

import com.ysd.iep.entity.po.PositionDB;
import com.ysd.iep.entity.po.RecommendDB;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public interface RecommendDao extends BaseDao<RecommendDB, String> {

    /**
     * 根据位置id查询所有的推荐课程
     * @param
     * @return
     */
    @Query(value = "select * from recommend where positionId= :#{#position.id}  order by weight desc limit 0,:#{#position.nums}",nativeQuery = true)
    List<RecommendDB> getByPositionId(@Param("position") PositionDB positionDB);


    List<RecommendDB> findByCoursetIdIn(List<Integer> coursetId);

    /**
     * 根据课程id和位置id删除推荐
     * @param coursetId
     * @param positionId
     */
    @Modifying
    @Query(value = "delete from recommend where coursetId=:cid and positionId=:pid",nativeQuery = true)
    void del(@Param("cid") String coursetId,@Param("pid")String positionId); /**

     * 根据课程id和批量位置id删除推荐
     * @param coursetId
     * @param positionId
     */
    @Modifying
    @Query(value = "delete from recommend where coursetId=:cid and positionId in (:pids)",nativeQuery = true)
    void del(@Param("cid") String coursetId,@Param("pids")String[] positionId);



}
