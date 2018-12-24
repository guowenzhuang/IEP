package com.ysd.iep.entity.dto;

import java.sql.Timestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("教师传输类")
@Data
public class TeacherDTO  {
	private String teaId;
	private String teaName;
	private Integer teaDepartmentid;
	private String teaTalk;
	private String teaDescribe;
	private Integer teaNumber;
	private String teaPhoto;
	private String teaSex;
	
}
