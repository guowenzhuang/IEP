package com.ysd.iep.service;

import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersDTO;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.query.UsersQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.UsersVo;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;


    public PagingResult<UsersVo> query(UsersQuery usersQuery) {
        Specification<UsersDB> specification= new Specification<UsersDB>() {
            @Override
            public Predicate toPredicate(Root<UsersDB> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                //名称模糊查询
                if (EmptyUtil.stringE(usersQuery.getUserName())) {
                    Path<String> namePath = root.get("loginName");
                    predicates.add(criteriaBuilder.like(namePath, "%" + usersQuery.getUserName() + "%"));
                }

                //创建时间查询
                Path<Timestamp> createTimePath = root.get("createTime");
                if(EmptyUtil.dateE(usersQuery.getBeginCreateTime())){
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(createTimePath, usersQuery.getBeginCreateTime()));
                }
                if (EmptyUtil.dateE(usersQuery.getEndCreateTime())) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(createTimePath, usersQuery.getEndCreateTime()));
                }

                //锁定查询
                if (EmptyUtil.stringE(usersQuery.getIsLockout())) {
                    Path<String> isLockoutPath = root.get("isLockout");
                    predicates.add(criteriaBuilder.equal(isLockoutPath, usersQuery.getIsLockout()));
                }

                //手机号模糊查询
                if (EmptyUtil.stringE(usersQuery.getProtectMTel())) {
                    Path<String> iphonePath = root.get("iphone");
                    predicates.add(criteriaBuilder.like(iphonePath, "%" + usersQuery.getProtectMTel() + "%"));
                }
                //邮箱模糊查询
                if (EmptyUtil.stringE(usersQuery.getProtectEMail())) {
                    Path<String> emailPath = root.get("email");
                    predicates.add(criteriaBuilder.like(emailPath, "%" + usersQuery.getProtectEMail() + "%"));
                }
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        };

        //排序分页
        Pageable pageable =null;
        if(EmptyUtil.stringE(usersQuery.getOrder())){
            Sort sort = new Sort(Sort.Direction.ASC, usersQuery.getOrder());
            pageable = PageRequest.of(usersQuery.getPage()-1, usersQuery.getRows(),sort);
        }else{
            pageable = PageRequest.of(usersQuery.getPage()-1, usersQuery.getRows());
        }
        Page<UsersDB> users = usersDao.findAll(specification, pageable);
        List<UsersDB> usersDBS=users.getContent();
        PagingResult<UsersVo> pagingResult=new PagingResult<UsersVo>();
        pagingResult
                .setTotal(users.getTotalElements())
                .setRows(BeanConverterUtil.copyList(usersDBS,UsersVo.class));
        return pagingResult;
    }

    /**
     * 根据哟用户名查找用户
     * @param name
     * @return
     */
    public UsersDTO userByName(String name){
        UsersDB usersDB= usersDao.findTopByLoginName(name);
        UsersDTO usersDTO= (UsersDTO) BeanConverterUtil.copyObject(usersDB,UsersDTO.class);
        return usersDTO;
    }

    /**
     * 修改用户某一列的值
     * @param uuid
     * @param fieldName
     * @param fieldValue
     * @return
     */
    @Transactional
    public Result updateUserField(String uuid,String fieldName,String fieldValue) {
        UsersDB usersDB=usersDao.findById(uuid).get();
        Result result=new Result().setSuccess(false);
        if(fieldName.equals("isLockout")){
            usersDB.setIsLockout(fieldValue);
            usersDB.setPsdWrongTime(0);
            result.setSuccess(true);
        }
        usersDao.save(usersDB);
        return result;
    }

}
