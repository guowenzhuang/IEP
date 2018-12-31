package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.SectionexamparperDao;
import com.ysd.iep.entity.Sectionexamparper;
import com.ysd.iep.entity.parameter.Result;
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

        List<Sectionexamparper> sectionexamparperList = sectionexamparperdao.selectsectionparperwherecourseandsection(courseid, sectionid);
        for (int i = 0; i < sectionexamparperList.size(); i++) {
            sectionexamparperList.get(i).setSectionexamrubricslist(null);
        }

        return sectionexamparperList;
    }


    /**
     * 根据课程id,章节id章节测试试卷id删除试卷
     *
     * @param courseid
     * @param sectionid
     * @param parperid
     * @return
     */
    @Override
    public Result deletsectionforcourseidandsectionidparperid(Integer courseid, Integer sectionid, String parperid) {
        int r = sectionexamparperdao.deletsectionforcourseidandsectionidparperid(courseid, sectionid, parperid);
        if (r > 0) {
            return new Result(true, "移除章节测试试卷成功", null);
        } else {
            return new Result(false, "移除章节测试试卷失败", null);
        }
    }
}
