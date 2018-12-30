package com.ysd.iep.service;

import com.ysd.iep.dao.ClassesDao;
import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.*;
import com.ysd.iep.entity.po.ClassesDB;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.properties.SystemProperties;
import com.ysd.iep.entity.query.StudentQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.StudentFeign;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import com.ysd.iep.util.PasswordEncrypt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
@Service
public class StudentService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RolesDao rolesDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired(required = false)
    private StudentFeign studentFeign;

    public PagingResult query(StudentQuery studentQuery){
        String roleId=rolesDao.findByName("学生").getId();
        Pageable pageable = PageRequest.of(studentQuery.getPage() - 1, studentQuery.getRows());
        Page<UsersDB> byRole = null;
        if(EmptyUtil.stringE(studentQuery.getName())){
            byRole=usersDao.findByRole(studentQuery.getName(),roleId,pageable);
        }else{
            byRole=usersDao.findByRole(roleId,pageable);
        }
        List<UsersDB> usersDBS = byRole.getContent();
        List<String>  userIds=usersDBS.stream().map(UsersDB::getId).collect(Collectors.toList());
        String ids = StringUtils.join(userIds, ",");
        Result<List<UsersStuDTO>> result = studentFeign.getByIds(ids);
        List<UsersStuDTO> usersStuDTOS=result.getMessage();

        for (int i = 0; i < usersStuDTOS.size(); i++) {
            UsersStuDTO ut=usersStuDTOS.get(i);
            UsersDB u=usersDBS.get(i);
            BeanConverterUtil.copyObject(u,ut);
            String cid = ut.getCid();
            if(cid!=null && (!cid.equals(""))){
            ClassesDB classesDB = classesDao.findById(cid).get();
            ut.setCode(classesDB.getCode());
            }
        }
        PagingResult pagingResult=new PagingResult();
        pagingResult.setTotal(byRole.getTotalElements());
        pagingResult.setRows(usersStuDTOS);
        return pagingResult;
    }

    @Transactional(rollbackOn = Exception.class)
    public void add(UsersStuDTO usersStuDTO) throws DataIntegrityViolationException{
        UsersDB users = usersDao.findTopByLoginName(usersStuDTO.getLoginName());
        if (users != null) {
            throw new DataIntegrityViolationException("用户名重复");
        }else{
            //用户表新增
            UsersDB usersDB= (UsersDB) BeanConverterUtil.copyObject(usersStuDTO,UsersDB.class);
            RolesDB rolesDB = rolesDao.findByName("学生");
            List<RolesDB> roleList=new ArrayList();
            roleList.add(rolesDB);
            usersDB.setRolesDBS(roleList);
            String password = PasswordEncrypt.encryptPassword(SystemProperties.INIT_PASSWORD);
            usersDB.setPassword(password);
            usersDB.setStatus(0);
            usersDB.setCreateTime(new Timestamp(System.currentTimeMillis()));
            UsersDB save = usersDao.save(usersDB);

            //学生表新增
            StudentAddDTO studentDTO= (StudentAddDTO) BeanConverterUtil.copyObject(usersStuDTO,StudentAddDTO.class);
            studentDTO.setSid(save.getId());
            studentFeign.add(studentDTO);
        }
    }
    @Transactional(rollbackOn = Exception.class)
    public void update(UsersStuDTO usersStuDTO) throws DataIntegrityViolationException {
        UsersDB users = usersDao.findTopByLoginName(usersStuDTO.getLoginName());
        if (users != null && !(users.getLoginName().equals(usersStuDTO.getLoginName()))) {
            throw new DataIntegrityViolationException("用户名重复");
        }else{
            UsersDB usersDB= usersDao.findById(usersStuDTO.getId()).get();
            usersDB.setProtectEMail(usersStuDTO.getProtectEMail());
            usersDB.setProtectMTel(usersStuDTO.getProtectMTel());
            usersDao.save(usersDB);
            StudentAddDTO studentDTO= (StudentAddDTO) BeanConverterUtil.copyObject(usersStuDTO,StudentAddDTO.class);
            studentDTO.setSid(usersDB.getId());
            studentFeign.add(studentDTO);
        }
    }

    public void delete(String id) {
        usersDao.deleteById(id);
        studentFeign.delete(id);
    }
}
