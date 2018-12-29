package com.ysd.iep.service;


import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.Sectionexamrubric;
import com.ysd.iep.entity.parameter.AddrubricQuery;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import org.springframework.data.domain.Page;

/**
 * @author gaohzongye
 * @date 2018/12/29
 * 章节测试Service
 */
public interface SectionrubricService {

    /**
     * 分页查询试题
     *
     * @return
     */
    Page<Sectionexamrubric> queryUserByuserQuery(RubricQuery rubricquery, Integer page, Integer rows);

    /**
     * 新增考试题干
     */
    Result addexamrubric(AddrubricQuery addrubricquery);

    /**
     * 新增考试题干(新增考试题(仅对新增多选单选))
     */
    Result addexamrubricjudegepack(AddrubricQuery addrubricquery);

}
