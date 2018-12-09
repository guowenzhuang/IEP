package com.ysd.iep.controller;


import com.sun.scenario.effect.Crop;
import com.ysd.iep.dao.RubricDao;
import com.ysd.iep.entity.Rubric;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.util.Cors;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rubric")
public class RubricController extends Cors {
    @Autowired
    private RubricDao rubricdao;

    @RequestMapping(value = "/addrubric", method = RequestMethod.POST)
    public Object addrubric(Rubric rubric) {
        String Id = UUIDUtils.getUUID();
        rubric.setId(Id);

        return rubricdao.save(rubric);
    }

    @RequestMapping(value = "/queryrubric", method = RequestMethod.POST)
    public Object queryrubric() {
        return rubricdao.findAll();
    }

    @RequestMapping(value = "/deleteredicbyid", method = RequestMethod.POST)
    public Object deleteredicbyid(String id) {
        System.out.println(id);
        try {
            rubricdao.deleteById(id);
            return new Result(true, "删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败", null);
        }
    }


}
