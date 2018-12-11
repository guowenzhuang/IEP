package com.ysd.iep.controller;

import com.ysd.iep.entity.Examparper;
import com.ysd.iep.entitySerch.ExamParperSerch;
import com.ysd.iep.service.ExamparperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/examParper")
public class ExamParperController {
    @Autowired
    private ExamparperService examparperService;
    @RequestMapping(value="/getqueryqueryByDynamicSQLPageExpaerper",method=RequestMethod.POST)
    private Object getqueryqueryByDynamicSQLPageExpaerper(ExamParperSerch examParperSerch){
        Page<Examparper> page=examparperService.queryqueryByDynamicSQLPageExpaerper(examParperSerch);
        Long total = page.getTotalElements();
        List<Examparper> list=page.getContent();
        System.out.println("rows==>"+list);
        for (Examparper examparper : list) {
            examparper.setExamrubricslist(null);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("total", total);
        map.put("rows", list);

        return map;
    }
}
