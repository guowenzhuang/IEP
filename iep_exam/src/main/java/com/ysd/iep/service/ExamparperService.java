package com.ysd.iep.service;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entitySerch.ExamParperSerch;
import org.springframework.data.domain.Page;

/***
 * 考试试卷
 */

public interface ExamparperService {
    /***
     * 多条件分页查询试卷显示
     * @param examParperSerch
     * @return
     */
  Page<Examparper> queryqueryByDynamicSQLPageExpaerper(ExamParperSerch examParperSerch);
}
