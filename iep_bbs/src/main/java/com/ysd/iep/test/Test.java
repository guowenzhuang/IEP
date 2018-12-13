package com.ysd.iep.test;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.ysd.iep.tools.BeanConverterUtil;


public class Test {

	public static void main(String[] args) throws ParseException {
		//BeanConverterUtil BeanUtils=new BeanConverterUtil();
		// a. 基本操作
		Admin admin = new Admin("Jack",19);

		// b. BeanUtils组件实现对象属性的拷贝
		//BeanUtils.copyProperty(admin, "userName", "jack");
		//BeanUtils.setProperty(admin, "age", 18);
		// 总结1： 对于基本数据类型，会自动进行类型转换!
		
		// c. 对象的拷贝
		Admin newAdmin = new Admin();
		BeanUtils.copyProperties(admin, newAdmin);
		System.out.println("admin==>"+admin);
		System.out.println("newAdmin==>"+newAdmin);
		// d. map数据，拷贝到对象中
		Admin adminMap = new Admin();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", "Jerry");
		map.put("age", 29);
		// 注意：map中的key要与javabean的属性名称一致
		//BeanUtils.populate(adminMap, map);
		// 测试
		System.out.println(adminMap.getUserName());
		System.out.println(adminMap.getAge());
	}

}
