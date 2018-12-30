package com.ysd.iep.service;

import com.ysd.iep.annotation.PermissionMethod;
import com.ysd.iep.annotation.PermissionType;
import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.*;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.properties.SystemProperties;
import com.ysd.iep.entity.query.UsersQuery;
import com.ysd.iep.entity.query.UsersRoleQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.entity.vo.UsersVo;
import com.ysd.iep.feign.StudentFeign;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import com.ysd.iep.util.PasswordEncrypt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@PermissionType("用户")
@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RolesDao rolesDao;
    @Autowired(required = false)
    private StudentFeign studentFeign;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;

    public PagingResult<UsersTeaDTO> get(UsersRoleQuery usersRoleQuery){
        //获取角色id
        String roleId=rolesDao.findByName(usersRoleQuery.getRoleName()).getId();
        //分页查询
        Pageable pageable = PageRequest.of(usersRoleQuery.getPage() - 1, usersRoleQuery.getRows());
        Page<UsersDB> byRole = null;
        if(EmptyUtil.stringE(usersRoleQuery.getName())){
            byRole=usersDao.findByRole(usersRoleQuery.getName(),roleId,pageable);
        }else{
            byRole=usersDao.findByRole(roleId,pageable);
        }
        List<UsersDB> usersDBS = byRole.getContent();
        List<String>  userIds=usersDBS.stream().map(UsersDB::getId).collect(Collectors.toList());
        String ids = StringUtils.join(userIds, ",");
        Result<List<UsersTeaDTO>> result=teacherFeign.get(ids);
        List<UsersTeaDTO> usersTeaDTOS=result.getMessage();
        for (int i = 0; i < usersTeaDTOS.size(); i++) {
            UsersTeaDTO ut=usersTeaDTOS.get(i);
            UsersDB u=usersDBS.get(i);
            BeanConverterUtil.copyObject(u,ut);
        }
        PagingResult pagingResult=new PagingResult();
        pagingResult.setTotal(byRole.getTotalElements());
        pagingResult.setRows(usersTeaDTOS);
        return pagingResult;
    }


    @PreAuthorize("hasAuthority('user:query')")
    @PermissionMethod("查询")
    public PagingResult<UsersVo> query(UsersQuery usersQuery) {
        Specification<UsersDB> specification = new Specification<UsersDB>() {
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
                if (EmptyUtil.dateE(usersQuery.getBeginCreateTime())) {
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
                Path<String> statusPath = root.get("status");
                predicates.add(criteriaBuilder.equal(statusPath, "0"));
                Predicate[] p = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(p));
            }
        };

        //排序分页
        Pageable pageable = null;
        if (EmptyUtil.stringE(usersQuery.getOrder())) {
            Sort sort = new Sort(Sort.Direction.ASC, usersQuery.getOrder());
            pageable = PageRequest.of(usersQuery.getPage() - 1, usersQuery.getRows(), sort);
        } else {
            pageable = PageRequest.of(usersQuery.getPage() - 1, usersQuery.getRows());
        }
        Page<UsersDB> users = usersDao.findAll(specification, pageable);
        List<UsersDB> usersDBS = users.getContent();
        PagingResult<UsersVo> pagingResult = new PagingResult<UsersVo>();
        pagingResult
                .setTotal(users.getTotalElements())
                .setRows(BeanConverterUtil.copyList(usersDBS, UsersVo.class));
        return pagingResult;
    }

    /**
     * 根据用户名查找用户
     *
     * @param name
     * @return
     */
    public UsersDTO userByName(String name) {
        UsersDB usersDB = usersDao.findTopByLoginName(name);
        UsersDTO usersDTO = (UsersDTO) BeanConverterUtil.copyObject(usersDB, UsersDTO.class);
        return usersDTO;
    }

    public List<UsersDTO> userById(String ids) {
        List<UsersDB> usersDB = usersDao.findAllById(Arrays.asList(ids.split(",")));
        List<UsersDTO> usersDTOS=BeanConverterUtil.copyList(usersDB,UsersDTO.class);
        return usersDTOS;
    }

    /**
     * 修改用户某一列的值
     *
     * @param uuid
     * @param fieldName
     * @param fieldValue
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('user:updateUserField')")
    @PermissionMethod("修改某一字段")
    public Result updateUserField(String uuid, String fieldName, String fieldValue) {
        UsersDB usersDB = usersDao.findById(uuid).get();
        Result result = new Result().setSuccess(false);
        if (fieldName.equals("isLockout")) {
            usersDB.setIsLockout(fieldValue);
            usersDB.setPsdWrongTime(0);
            result.setSuccess(true);
        } else if (fieldName.equals("password")) {
            String password = PasswordEncrypt.encryptPassword(SystemProperties.INIT_PASSWORD);
            usersDB.setPassword(password);
            result.setSuccess(true);
        }
        usersDao.save(usersDB);
        return result;
    }

    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('user:setRole')")
    @PermissionMethod("设置角色")
    public void setRoles(String uuid, String roleIds, String direction) {
        System.out.println("uuid==>"+uuid);
        String[] ids = roleIds.split(",");
        //新增角色
        if (direction.equals("right")) {
            for (String id : ids) {
                RolesDB rolesDB = rolesDao.findById(id).get();
                if (rolesDB.getName().equals("学生")) {
                    StudentDTO studentDTO = new StudentDTO().setSid(uuid);
                    studentFeign.add(studentDTO);
                }
                else if(rolesDB.getName().equals("老师")){
                    TeacherDTO teacherDTO=new TeacherDTO().setTeaId(uuid);
                    System.out.println(teacherDTO);
                    teacherFeign.AddTeacher(uuid);
                }
                usersDao.addRole(uuid, id);
            }
        }
        //移除角色
        else {
            for (String id : ids) {
                RolesDB rolesDB = rolesDao.findById(id).get();
                if (rolesDB.getName().equals("学生")) {
                    studentFeign.delete(uuid);
                }
                else if(rolesDB.getName().equals("老师")){
                    teacherFeign.deleteTeacherById(uuid);
                }
                usersDao.deleteRole(uuid, id);
            }
        }
    }

    /**
     * 新增用户
     *
     * @param usersDB
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('user:add')")
    @PermissionMethod("新增用户")
    public void add(UsersDB usersDB) {
        String password = PasswordEncrypt.encryptPassword(SystemProperties.INIT_PASSWORD);
        usersDB.setPassword(password);
        usersDB.setStatus(0);
        usersDB.setCreateTime(new Timestamp(System.currentTimeMillis()));
        usersDao.save(usersDB);
    }

    /**
     * 删除用户
     *
     * @param uuid
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('user:delete')")
    @PermissionMethod("用户删除")
    public void delete(String uuid) {
        usersDao.deleteStatus(uuid);
    }

    /**
     * 修改用户
     *
     * @param usersUpdateDTO
     */
    @Transactional(rollbackOn = Exception.class)
    @PreAuthorize("hasAuthority('user:update')")
    @PermissionMethod("用户修改")
    public void update(UsersUpdateDTO usersUpdateDTO) {
        UsersDB usersDB = usersDao.findTopByLoginName(usersUpdateDTO.getLoginName());
        usersDB.setProtectEMail(usersUpdateDTO.getProtectEMail());
        usersDB.setProtectMTel(usersUpdateDTO.getProtectMTel());
    }

    /**
     *根据用户id修改用户的手机号和邮箱
     * @param user
     */
    public void updateUserById(UsersUpdateDTO user) {
        UsersDB usersDB=usersDao.findById(user.getId()).get();
        usersDB.setProtectMTel(user.getProtectMTel());
        usersDB.setProtectEMail(user.getProtectEMail());
        usersDao.save(usersDB);
    }
}
