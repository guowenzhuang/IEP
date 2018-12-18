package com.ysd.iep.controller;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author gaozhongye
 * @date 2018/12/16
 * 考试试卷 控制器
 */
@RestController
@RequestMapping("/examparper")
public class ExamParperControllerEr {

    @Autowired
    ExamparperDao examparperdao;


    /**
     * 新增试卷类
     */
    @RequestMapping(value = "/addparper", method = RequestMethod.POST)
    public Object addparper(ExamParperSerch examParperSerch) {

        System.out.println("********************" + examParperSerch.getDuration());
        try {
            String id = UUIDUtils.getUUID();
            /*弄出来一个新的考试试卷对象*/
            Examparper examparper = examparperdao.save(new Examparper(id, examParperSerch.getType(), examParperSerch.getTitle(), examParperSerch.getSubject(), examParperSerch.getDuration(), "未开放", examParperSerch.getTotal(), null, null, new Date(), null, null, null, null, null, examParperSerch.getExamshortesttime(), null));
            /*将考试试卷的考试试题集合置空*/
            examparper.setExamrubricslist(null);


            return new Result(true, "添加试卷成功", id);


        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加试卷失败", null);

        }
    }

}
