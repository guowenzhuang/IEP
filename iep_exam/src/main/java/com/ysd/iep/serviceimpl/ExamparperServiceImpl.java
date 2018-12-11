package com.ysd.iep.serviceimpl;

import com.ysd.iep.dao.ExamparperDao;
import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       // String time=formatter.format(examParperSerch.getCreatetime());
      //  Sort sort=new Sort(Sort.Direction.DESC,time);
        System.out.println("第几页===>"+examParperSerch.getPage());
        System.out.println("第几页===>"+examParperSerch.getSubject());
        PageRequest pageable=PageRequest.of(examParperSerch.getPage()-1,examParperSerch.getRows());
        return examparperDao.findAll(this.getWhereClause(examParperSerch),pageable);
    }

    private Specification<Examparper> getWhereClause(final ExamParperSerch examParperSerch) {
        return new Specification<Examparper>() {
            @Override
            public Predicate toPredicate(Root<Examparper> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                List exceptonList = predicate.getExpressions();
                if (examParperSerch.getSubject()!= null&&!"".equals(examParperSerch.getSubject())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("Subject"), "%" + examParperSerch.getSubject() + "%"));
                }

                if (examParperSerch.getTitle() != null &&!"".equals(examParperSerch.getTitle())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("Title"), "%" + examParperSerch.getTitle() + "%"));
                }
                if (examParperSerch.getType()!= null&&!" ".equals(examParperSerch.getType())) {
                    exceptonList.add(criteriaBuilder.like(root.<String>get("Type"), "%" + examParperSerch.getType() + "%"));
                }
                if (examParperSerch.getState()!=null&&!"".equals(examParperSerch.getState())){
                    exceptonList.add(criteriaBuilder.like(root.<String>get("State"),"%"+examParperSerch.getState()+"%"));
                }



                return predicate;
            }
        };
    }

}
