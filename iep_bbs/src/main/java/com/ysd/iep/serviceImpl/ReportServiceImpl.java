package com.ysd.iep.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ysd.iep.dao.ReportRepository;
import com.ysd.iep.entity.Report;

import com.ysd.iep.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{
	@Autowired
	private ReportRepository reportRepository;

	//根据帖子id查询举报信息
	@Override
	public List<Report> getReportid(Integer replyId){
		System.out.println("reolaId==>"+replyId);
		List<Report> reports=reportRepository.getReportid(replyId);
		reports.forEach(item->{
			item.getReply().setReportList(null);
			item.getReply().setLikeList(null);
			item.getReply().setPost(null);
		});
	
		return reports;
	}
	//删除举报信息
	@Override
	public Integer deletereport(Integer reportId) {
		// TODO Auto-generated method stub
		return reportRepository.deletereport(reportId);
	}

}
