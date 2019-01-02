package com.ysd.iep.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ysd.iep.entity.po.ClassesDB;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.iep.dao.DepartmentDao;
import com.ysd.iep.dao.RolesDao;
import com.ysd.iep.dao.UsersDao;
import com.ysd.iep.entity.dto.*;
import com.ysd.iep.entity.po.DepartmentDB;
import com.ysd.iep.entity.po.RolesDB;
import com.ysd.iep.entity.po.UsersDB;
import com.ysd.iep.entity.properties.SystemProperties;
import com.ysd.iep.entity.query.TeacherQuery;
import com.ysd.iep.entity.query.UsersRoleQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.feign.TeacherFeign;
import com.ysd.iep.util.BeanConverterUtil;
import com.ysd.iep.util.EmptyUtil;
import com.ysd.iep.util.ExcelUtil;
import com.ysd.iep.util.PasswordEncrypt;

@Service
public class TeacherService {

	@Autowired
    private UsersDao usersDao;
    @Autowired
    private RolesDao rolesDao;
    @Autowired 
    private DepartmentDao depDao;
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
            String teaDepartmentid = ut.getTeaDepartmentid();
            if(teaDepartmentid!=null && (!teaDepartmentid.equals(""))){
                DepartmentDB departmentDB = depDao.findById(teaDepartmentid).get();
                ut.setDepName(departmentDB.getName());
            }
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
        	addNoCheck(usersteaDTO);
        }
    }
    
    @Transactional(rollbackOn = Exception.class)
    public void addNoCheck(UsersTeaDTO usersteaDTO) {
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
            teacherDTO.setTeaId(save.getId());
            teacherFeign.addTeacher(teacherDTO);
        
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
    
    public List<UsersTeaDTO> exports(TeacherQuery teacherQuery) {
        String roleId=rolesDao.findByName("老师").getId();
        List<UsersDB> usersDBS = null;
        if(EmptyUtil.stringE(teacherQuery.getName())){
            usersDBS=usersDao.findByRole(teacherQuery.getName(),roleId);
        }else{
            usersDBS=usersDao.findByRole(roleId);
        }
        List<String>  userIds=usersDBS.stream().map(UsersDB::getId).collect(Collectors.toList());
        String ids = StringUtils.join(userIds, ",");
        Result<List<UsersTeaDTO>> result = teacherFeign.get(ids);
        List<UsersTeaDTO> usersTeaDTOS=result.getMessage();
        for (int i = 0; i < usersTeaDTOS.size(); i++) {
        	UsersTeaDTO ut=usersTeaDTOS.get(i);
            UsersDB u=usersDBS.get(i);
            BeanConverterUtil.copyObject(u,ut);
            String depid = ut.getTeaDepartmentid();
            if(depid!=null && (!depid.equals(""))){
                DepartmentDB depDB = depDao.findById(depid).get();
                ut.setTeaDepartmentid(depDB.getName());
            }
        }
        return usersTeaDTOS;
    }
    
    @Transactional(rollbackOn = Exception.class)
    public void importTeacher(MultipartFile file) throws IOException, InstantiationException, IllegalAccessException,RuntimeException {
        ExcelUtil excelUtil = ExcelUtil.getInstance();
        InputStream inputStream = file.getInputStream();
        List usersTeaDTOs = excelUtil.importExcel(UsersTeaDTO.class, inputStream, item -> {
        	UsersTeaDTO usersTeaDTO = (UsersTeaDTO) item;
            UsersDB byLoginName = usersDao.findTopByLoginName(usersTeaDTO.getLoginName());
            if (byLoginName != null) {
                return null;
            }else{
                String name = usersTeaDTO.getTeaDepartmentid();
                if(name!=null && (!"".equals(name.trim()))){
                    DepartmentDB departmentDB = depDao.findByName(name);
                    usersTeaDTO.setTeaDepartmentid(departmentDB.getDepartmentId());
                }

            }
            return usersTeaDTO;
        });
        importTeacher(usersTeaDTOs);
    }
    
    private void importTeacher(List<UsersTeaDTO> usersTeaDTOS){
    	usersTeaDTOS.forEach(item ->{
            addNoCheck(item);
        });
    }
}
