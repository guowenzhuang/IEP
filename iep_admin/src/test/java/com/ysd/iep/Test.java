package com.ysd.iep;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 80795
 * @date 2018/11/12 8:55
 */
public class Test {
    @org.junit.Test
    public void testset(){
        Set<String> roleSet = new HashSet<>();
        roleSet.add("{authority=ROLE_ADMIN}");
        String defaultedRole="{authority=ROLE_ADMIN}";
        if (roleSet.contains(defaultedRole)) {
            System.out.println("as");
        }
        System.out.println("false");
    }
}
