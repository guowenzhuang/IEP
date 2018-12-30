package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.service.SectionexamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaozhongye
 * @date 2018/12/30
 * 章节测试试卷service实现类
 */

@Service
public class SectionexamparperServiceimpl implements SectionexamparperService {
    @Autowired
    SectionexamparperDao sectionexamparperdao;

    /**
     * 根据课程id 章节id查询 章节测试试卷
     */
    @Override
    public List<Sectionexamparper> selectparperforcoueseidandsectionid(Integer courseid, Integer sectionid) {
        return sectionexamparperdao.selectsectionparperwherecourseandsection(courseid, sectionid);
    }

}
