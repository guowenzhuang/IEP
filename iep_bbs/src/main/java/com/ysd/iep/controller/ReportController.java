package com.ysd.iep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.iep.entity.Post;
import com.ysd.iep.entity.PostQuery;
import com.ysd.iep.entity.Reply;
import com.ysd.iep.entity.Report;

import com.ysd.iep.service.ReportService;

@RestController
@RequestMapping(value="report")

public class ReportController {
	
 @Autowired
 private ReportService reportservice;
 
 
 @RequestMapping(value="getreport",method=RequestMethod.POST)
 public Object getReportid(Integer replyId) {
	 Map<String, Object> map = new HashMap<String, Object>();
    List<Report> list =  reportservice.getReportid(replyId);
   map.put("rows", list);
  return map;
}
 
 @RequestMapping(value="deleteport",method=RequestMethod.POST)
 public Object deleteport(Integer reportId) {
	 Map<String, Object> map = new HashMap<String, Object>();
	 int n=reportservice.deletereport(reportId);
	 if(n>0) {
		 map.put("success", true);
		 map.put("message", "删除成功");
		 return map;
	 }else {
		 map.put("success", false);
		 map.put("message", "删除失败");
		 return map;
	 }
 }
 
}
