package com.ysd.iep.service;

import com.ysd.iep.dao.RecommendDao;
import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.po.RecommendDB;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class CourseService {
    @Autowired(required = false)
    private TeacherFeign teacherFeign;
    @Autowired
    private RecommendDao recommendDao;

    @PreAuthorize("hasAuthority('cource:query')")
    public PagingResult<CourseDTO> query(CourseQuery courseQuery){

        Map map= BeanConverterUtil.objectToMap(courseQuery);

        PagingResult<CourseDTO> pagingResult=teacherFeign.getPaginate(map);

        List<CourseDTO> list= pagingResult.getRows();
        List<Integer> ids=list.stream().map(CourseDTO::getCourId).collect(Collectors.toList());
        List<RecommendDB> recommendDBS = recommendDao.findByCoursetIdIn(ids);
        List<Integer> rIds= recommendDBS.stream().map(RecommendDB::getCoursetId).collect(Collectors.toList());
        list.forEach(item -> {
           if(rIds.contains(item.getCourId())){
               item.setIsRecommend(true);
           }else{
               item.setIsRecommend(false);
           }
        });
        return pagingResult;
    }
}
