package com.ysd.iep.service.impl;

import com.ysd.iep.dao.ChapterRepository;
import com.ysd.iep.dao.CourseRepository;
import com.ysd.iep.dao.TeacherRepository;
import com.ysd.iep.entity.Chapters;
import com.ysd.iep.entity.Course;
import com.ysd.iep.entity.dto.CourseDTO;
import com.ysd.iep.entity.dto.PagingResult;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.query.CourseQuery;
import com.ysd.iep.service.CourseService;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository coursedao;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    /**
     * 课程的分页查询
     */
    public Page<Course> getPaginate(CourseQuery courseQuery) {
        Specification<Course> specification = new Specification<Course>() {
            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                Path<String> cardNoPath = root.get("courName");
                if (EmptyUtil.stringE(courseQuery.getCourName())) {
                    predicates.add(cb.like(cardNoPath, "%" + courseQuery.getCourName() + "%"));
                }
                if (EmptyUtil.stringE(courseQuery.getCourTeaid())) {
                    Path<String> teaPath = root.get("courTeaid");
                    predicates.add(cb.equal(teaPath,courseQuery.getCourTeaid()));
                }
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));

            }
        };
        // FIXME 怎么办
        // 课程表  + 评论数量 浏览数量 倒叙 升序
        // 浏览数量+1
        // 有人在课程评论   评论属性+1
        PageRequest pageRequest = null;
        if (EmptyUtil.stringE(courseQuery.getOrderBy())) {
            Sort sort = new Sort(Sort.Direction.DESC, courseQuery.getOrderBy());
            pageRequest = PageRequest.of(courseQuery.getPage() - 1, courseQuery.getPageSize(), sort);
        } else {
            pageRequest = PageRequest.of(courseQuery.getPage() - 1, courseQuery.getPageSize());
        }
        Page<Course> c = coursedao.findAll(specification, pageRequest);
        return c;


    }



    /**
     * 前台课程显示
     */
    @Override
    public Page<Course> queryCourseDepidAllPage(CourseQuery courseQuery) {
        System.out.println("courseQuery==>"+courseQuery);
        List<String> teacherIds=new ArrayList<>();
        if(courseQuery.getCourDepid()!=null){
            String courDepid = courseQuery.getCourDepid();
             teacherIds = teacherRepository.findByteaIds(courDepid);
            if(teacherIds==null || teacherIds.size()==0){
                return null;
            }
        }
        List<String> finalTeacherIds = teacherIds;
        Specification<Course> specification = new Specification<Course>() {
            @Override
            public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
            // 名称模糊查询
                if (EmptyUtil.stringE(courseQuery.getCourDepid())) {
                    CriteriaBuilder.In<Object> courTeaid = criteriaBuilder.in(root.get("courTeaid"));
                    for (String id : finalTeacherIds) {
                        courTeaid.value(id);
                    }
                    predicates.add(courTeaid);
                }
            Predicate[] p = new Predicate[predicates.size()];
            return criteriaBuilder.and(predicates.toArray(p));
        }
        };
        Pageable pageable = null;
        if (EmptyUtil.stringE(courseQuery.getOrderBy())) {
            Sort sort = new Sort(Sort.Direction.ASC, courseQuery.getOrderBy());
            pageable = PageRequest.of(courseQuery.getPage() - 1, courseQuery.getPageSize(), sort);
        } else {
            pageable = PageRequest.of(courseQuery.getPage() - 1, courseQuery.getPageSize());
        }
        Page<Course> course = coursedao.findAll(specification, pageable);

        return course;


    }
    @Override
    public Result deleteById(Integer courId) {
             coursedao.deleteById(courId);
             return new Result(true);
    }

    @Override
    public Result insertCourse(Course course) {
        coursedao.save(course);
        return new Result(true);
    }

    @Override
    public Result updateCourse(Course course) {

        Course c = coursedao.getOne(course.getCourId());
        if(EmptyUtil.stringE(course.getCourName()));
            c.setCourName(course.getCourName());
        if(EmptyUtil.doubleE(course.getCourPrice()));
        c.setCourPrice(course.getCourPrice());
        if(EmptyUtil.intE(course.getCourMark()));
        c.setCourMark(course.getCourMark());
        if(EmptyUtil.stringE(course.getCourPicurl()));
        c.setCourPicurl(course.getCourPicurl());
        if(EmptyUtil.stringE(course.getCourContent()));
        c.setCourContent(course.getCourContent());
        coursedao.save(c);
        return new Result(true);
    }

    @Override
    public List<CourseDTO> findByCourseId(String courId) {
        List dd = new ArrayList<CourseDTO>();
        if (courId != null && courId != "") {
            String[] s = courId.split(",");

            List<Course> byCourseIds = coursedao.findByCourseIds(s);
            List<String> list = Arrays.asList(s);
            byCourseIds.sort((o1, o2) -> {
                int i1=list.indexOf(o1.getCourId()+"");
                int i2=list.indexOf(o2.getCourId()+"");
                System.out.println("i1"+i1);
                System.out.println("i2"+i2);
                return i1-i2;
            });
            System.out.println(byCourseIds);
            dd= BeanConverterUtil.copyList(byCourseIds,CourseDTO.class,item -> {
                CourseDTO courseDTO= (CourseDTO) item;
                List<Integer> chaIds = chapterRepository.queryCountById(courseDTO.getCourId());
                List<Integer> ids=new ArrayList<>();
                chaIds.forEach(action -> {
                    queryChaId(action,ids,null);
                });
                courseDTO.setCountChaSum(ids.size());
                courseDTO.setChaIds(ids);
            });
        }
        return dd;
    }

    private void queryChaId(Integer parId,List<Integer> ids,List<Integer> parIds){
        List<Integer> list = chapterRepository.queryIdByParentId(parId);
        if((list==null || list.size()==0) && parIds!=null){
            if(!ids.containsAll(parIds)){
                ids.addAll(parIds);
            }
        }else{
            list.forEach(item -> {
                queryChaId(item,ids,list);
            });
        }

    }

    /**
     * 根据教师Id查询课程
     */
    @Override
    public List<Course> queryCourByteaId(String teaId) {
        List<Course> list = null;
        if (EmptyUtil.stringE(teaId)) {
            list = coursedao.findByCourTeaid(teaId);
        }
        return list;

    }

    @Override
    public List<Integer> queryCourByteaId(List<String> teaid) {
        return coursedao.findByCourTeaidIn(teaid).stream().map(Course::getCourId).collect(Collectors.toList());
    }



    /**
     * 提供根据课程id查询单个课程信息
     */
	@Override
	public Course queryCourByid(Integer courid) {
		// TODO Auto-generated method stub
		return coursedao.findByCourseId(courid);
	}



	@Override
	public PagingResult<Course> queryCourseBydepid(CourseQuery courseQuery) {
		List<String> teaids = teacherRepository.findByteaIds(courseQuery.getCourDepid());
        System.out.println("teaids>>>"+teaids);
        String teaid = StringUtils.join(teaids,",");
        System.out.println("teaid*****"+teaid);
        courseQuery.setCourTeaid(teaid);
        //分页查询
        Pageable pageable = PageRequest.of(courseQuery.getPage() - 1, courseQuery.getPageSize());
        Page<Course> course = null;
        if (EmptyUtil.stringE(courseQuery.getCourDepid())){
            course = coursedao.findByteaIds(teaid,pageable);
        }else{
            course = coursedao.findAll(pageable);
        }
        List<Course> courseList = course.getContent();
        PagingResult pagingResult = new PagingResult();
        pagingResult.setTotal(course.getTotalElements());
        pagingResult.setRows(courseList);
        return pagingResult;
	}




}
