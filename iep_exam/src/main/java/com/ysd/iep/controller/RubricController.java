package com.ysd.iep.controller;


import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Rubric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RubricController {
    @Autowired
    RubricDao rubricdao;


    @RequestMapping(value = "/queryrubricall", method = RequestMethod.GET)
    public Object queryrubric() {



        return null;
    }


}
