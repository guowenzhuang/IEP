package com.ysd.iep.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.entity.dto.UsersStuDTO;
import com.ysd.iep.entity.dto.UsersTeaDTO;
import com.ysd.iep.entity.query.StudentQuery;
import com.ysd.iep.entity.query.TeacherQuery;
import com.ysd.iep.entity.query.UsersRoleQuery;
import com.ysd.iep.entity.vo.PagingResult;
import com.ysd.iep.service.TeacherService;
import com.ysd.iep.service.UtilService;
import com.ysd.iep.util.ExcelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/teacher", tags="教师API")
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	 @Autowired
	 private TeacherService teaService;
	 @Autowired
	 private UtilService utilService;
	 
	@GetMapping("/teacherQuery")
    @ApiOperation("根据教师分页查询")
    public  PagingResult<UsersTeaDTO> getTeacher(TeacherQuery teacherQuery){
        System.out.println(teacherQuery);
        return teaService.get(teacherQuery);
    }
	
	@PostMapping("/addTeacher")
    @ApiOperation("添加教师")
	public Result addTeacher(@RequestBody UsersTeaDTO userteaDTO) {
		teaService.addTeacher(userteaDTO);
		return new Result(true,"新增成功");
	}
	
	@PutMapping("/{id}")
    public Result update(@PathVariable("id") String id,@RequestBody UsersTeaDTO userTeaDTO){
        try {
        	userTeaDTO.setId(id);
            teaService.update(userTeaDTO);
        } catch (DataIntegrityViolationException e) {
            return new Result<String>(false,e.getMessage());
        }
        return new Result(true,"修改成功");
    }
	
	@DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable("id") String id){
		teaService.delete(id);
        return new Result<String>(true,"删除成功");
    }
	
	@GetMapping("getTemplate")
    public List<Map> getTemplate(){
        return utilService.CheckBoxClassMapper(UsersTeaDTO.class);
    }
	
	@GetMapping("expertTemplate")
    public void expertTemplate(HttpServletResponse response, String names){
        try {
            ExcelUtil.TemplateExprot(response,"教师模板.xlsx", Arrays.asList(names.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	@GetMapping(value="exports")
    public void exports(TeacherQuery teacherQuery, HttpServletResponse response){
        List<UsersTeaDTO> exports = teaService.exports(teacherQuery);
        try {
            ExcelUtil.exportExcel(response,"教师.xlsx",exports);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
	
	@PostMapping("import")
    public Result importStudent(MultipartFile file) throws IOException {
        try {
            teaService.importTeacher(file);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }
        return new Result(true,"导入成功");

    }
	
}
