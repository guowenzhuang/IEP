package com.ysd.iep.service;

import com.ysd.iep.annotation.ExcelField;
import com.ysd.iep.entity.dto.Result;
import com.ysd.iep.util.ExcelUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

@Service
public class UtilService {

    public List<Map> CheckBoxClassMapper(Class clazz) {
        List<Map> mapList = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            //伴生对象
            if (f.getName().equals("Companion")) {
                continue;
            }
            f.setAccessible(true);
            Map map = new HashMap();
            ExcelField excelField = f.getDeclaredAnnotation(ExcelField.class);
            map.put("label", f.getName());
            map.put("noNull", false);
            if (excelField == null) {
                map.put("name", f.getName());
            } else {
                if (excelField.templaletDisplay() == true) {//如果隐藏跳过
                    continue;
                }
                map.put("name", excelField.value());
                map.put("noNull", excelField.notNull());
            }
            mapList.add(map);
        }
        return mapList;
    }


}