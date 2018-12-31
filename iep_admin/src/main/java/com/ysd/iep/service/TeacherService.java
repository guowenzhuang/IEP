package com.ysd.iep.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.StudentAddDTO;
import com.ysd.iep.entity.dto.TeacherAddDTO;
import com.ysd.iep.entity.dto.UsersStuDTO;
import com.ysd.iep.entity.dto.UsersTeaDTO;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.properties.SystemProperties;
import com.ysd.iep.entity.query.TeacherQuery;
import com.ysd.iep.entity.query.UsersRoleQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import com.ysd.iep.util.PasswordEncrypt;

@Service
public class TeacherService {

	@Autowired
    private UsersDao usersDao;
    @Autowired
    private RolesDao rolesDao;
    @Autowired(required = false)
    private TeacherFeign teacherFeign;
    
    public PagingResult<UsersTeaDTO> get(TeacherQuery teacherQuery){
        //获取角色id
        String roleId=rolesDao.findByName("老师").getId();
        //分页查询
        Pageable pageable = PageRequest.of(teacherQuery.getPage() - 1, teacherQuery.getRows());
        Page<UsersDB> byRole = null;
        if(EmptyUtil.stringE(teacherQuery.getName())){
            byRole=usersDao.findByRole(teacherQuery.getName(),roleId,pageable);
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
    @Transactional(rollbackOn = Exception.class)
    public void addTeacher(UsersTeaDTO usersteaDTO) {
    	UsersDB users = usersDao.findTopByLoginName(usersteaDTO.getLoginName());
    	if (users != null) {
            throw new DataIntegrityViolationException("用户名重复");
        }else {
        	//用户表新增
        	UsersDB usersDB= (UsersDB) BeanConverterUtil.copyObject(usersteaDTO,UsersDB.class);
        	RolesDB rolesDB = rolesDao.findByName("老师");
        	List<RolesDB> roleList=new ArrayList();
            roleList.add(rolesDB);
            usersDB.setRolesDBS(roleList);
            String password = PasswordEncrypt.encryptPassword(SystemProperties.INIT_PASSWORD);
            usersDB.setPassword(password);
            usersDB.setStatus(0);
            usersDB.setCreateTime(new Timestamp(System.currentTimeMillis()));
            UsersDB save = usersDao.save(usersDB);
            
          //教师表新增
            TeacherAddDTO teacherDTO= (TeacherAddDTO) BeanConverterUtil.copyObject(usersteaDTO,TeacherAddDTO.class);
            System.out.println("教师信息 teacherDTO.toString()>>>>>>>"+teacherDTO.toString());
            teacherDTO.setTeaId(save.getId());
            System.out.println("教师信息 teacherDTO.toString()ssssss>>>>>>>"+teacherDTO.toString());
            teacherFeign.addTeacher(teacherDTO);
        }
    }
    
    @Transactional(rollbackOn = Exception.class)
    public void update(UsersTeaDTO userTeaDTO) throws DataIntegrityViolationException {
        UsersDB users = usersDao.findTopByLoginName(userTeaDTO.getLoginName());
        if (users != null && !(users.getLoginName().equals(userTeaDTO.getLoginName()))) {
            throw new DataIntegrityViolationException("用户名重复");
        }else{
            UsersDB usersDB= usersDao.findById(userTeaDTO.getId()).get();
            usersDB.setProtectEMail(userTeaDTO.getProtectEMail());
            usersDB.setProtectMTel(userTeaDTO.getProtectMTel());
            usersDao.save(usersDB);
            TeacherAddDTO teacherDTO= (TeacherAddDTO) BeanConverterUtil.copyObject(userTeaDTO,TeacherAddDTO.class);
            teacherDTO.setTeaId(usersDB.getId());
            teacherFeign.addTeacher(teacherDTO);
        }
    }
    public void delete(String id) {
        usersDao.deleteById(id);
        teacherFeign.deleteTeacherById(id);
    }
}
