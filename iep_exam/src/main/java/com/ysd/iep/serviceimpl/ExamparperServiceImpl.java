package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ExamparperServiceImpl implements ExamparperService {
    @Autowired
    private ExamparperDao examparperDao;

    /***
     * 多条件分页查询试卷显示
     * @param examParperSerch
     * @return
     */
    @Override
    public Page<Examparper> queryqueryByDynamicSQLPageExpaerper(ExamParperSerch examParperSerch) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Sort sort = new Sort(Sort.Direction.DESC, "createtime");
        PageRequest pageable = PageRequest.of(examParperSerch.getPage() - 1, examParperSerch.getRows(), sort);
        return examparperDao.findAll(this.getWhereClause(examParperSerch), pageable);
    }

    /***
     * 设置开考时间
     * @param examparper
     * @return
     */
    @Override
    public Result updateStartExamtime(Examparper examparper) {
        if (examparper.getState().equals("考试中")) {
            return new Result(false, "考试中不能重新设置开考时间", null);
        } else if (examparper.getState().equals("考试结束")) {
            return new Result(false, "考试已经结束不能重新设置开考时间", null);
        } else {
            Examparper examparper1 = examparperDao.findById(examparper.getId()).orElse(null);
            examparper1.setExamtime(examparper.getExamtime());
            try {
                examparperDao.save(examparper1);
                return new Result(true, "设置成功", null);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "设置失败", null);
            }
        }
    }

    /***
     * 试卷管理的分页显示sql拼接
     * @param examParperSerch
     * @return
     */
    private Specification<Examparper> getWhereClause(final ExamParperSerch examParperSerch) {
        return new Specification<Examparper>() {
            @Override
            public Predicate toPredicate(Root<Examparper> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                List exceptonList = predicate.getExpressions();
                if (examParperSerch.getSubject() != null && !"".equals(examParperSerch.getSubject())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("subject"), "%" + examParperSerch.getSubject() + "%"));
                }

                if (examParperSerch.getTitle() != null && !"".equals(examParperSerch.getTitle())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("title"), "%" + examParperSerch.getTitle() + "%"));
                }
                if (examParperSerch.getType() != null && !" ".equals(examParperSerch.getType())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("type"), "%" + examParperSerch.getType() + "%"));
                }
                if (examParperSerch.getState() != null && !"".equals(examParperSerch.getState())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("state"), "%" + examParperSerch.getState() + "%"));
                }


                return predicate;
            }
        };
    }

}
