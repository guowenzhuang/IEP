package com.ysd.iep;

import com.ysd.iep.service.ModulesService;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class Test {
    @org.junit.Test
    public void testset(){
        Class z=ModulesService.class;
        Method[] methods=z.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
    }
}
