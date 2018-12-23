package com.ysd.iep.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @Description:   把Spring-data-Jpa 原生SQL查询出的List<Object[]>字段值数组集合 转化成实体对象集合
 * @ClassName:     JpaObjectsToEntity.java
 * @author         Mashuai
 * @Date           2018年1月30日 下午9:48:42
 * @Email          1119616605@qq.com
 */
public class JpaObjectsToEntity {
	
	
	
	
	
	
	/**
	 * 注:只有当结果实体类与数据表没有ORM映射时才使用此方法
	 * ^^^重要:此方法使用前提^^^必须保证原生SQL结果集的字段顺序都和实体类的字段顺序完全一致.[结果集字段名称与实体类字段名称无关;结果集字段顺序与实体类字段顺序有关]
	 * 把Spring-data-Jpa 原生SQL查询出的List<Object[]>字段值数组集合 转化成通常使用的实体对象集合
	 * @param objectsList Jpa查询结果(实体与数据表没有ORM映射关系)值数组集合
	 * @param clazz  想要得到的实体类集合(实体与数据表没有ORM映射关系)
	 * @return
	 */
	public static <T>T jpaResultToObjectList(List<Object[]> objectsList,Class<T> clazz){
		
		Class<?> currentClass = null;//当前对象的描述
		int fieldLength = 0;//当前对象属性个数
		Field[] fields = null;//当前对象所有的字段
		String[] fieldNames = null;//当前对象所有的字段名称
		//---------------  以上变量声明为非静态变量原因:防止并发访问静态不安全.
		List<Object> list = new ArrayList<Object>();
		Object object = null;
		//获取当前对象的描述
		currentClass = clazz;
		//获取当前对象的所有属性
		fields = currentClass.getDeclaredFields();
		fieldLength = fields.length;
		fieldNames = new String[fieldLength];
		for(int i = 0;i<fieldLength;i++){
			fieldNames[i]= fields[i].getName();
		}
		//获取值数组集合的迭代器
		Iterator<Object[]> objectsIterator = objectsList.iterator();
		//遍历结果集合		
		Object[] values = null;//每一个实体对象所有字段值所对应的一个值数组
		while(objectsIterator.hasNext()){//查询出的值数组结果集是否有数据
			values = objectsIterator.next();//每一个实体对象所有字段值所对应的一个值数组
			try {
				object = currentClass.newInstance();
			} catch (InstantiationException e) {
				//  TODO 此处省略记录日志
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 此处省略记录日志
				e.printStackTrace();
			}//构造一个对象实例
			for(int i=0;i<fieldLength;i++){//给对象的每个字段设置值
				Object value = null;
				try {//根据实体类的属性顺序获取值数组对应字段的值
//					value = rSet.getObject(fieldNames[i]);//根据对象的属性名称获取数据库对应字段的值
					fields[i].setAccessible(true);//设置对象属性允许访问，以便设置值
//					System.out.println(fields[i]+"-:"+value+"----->"+object); //输出当前正在设置的字段及其值
					fields[i].set(object, values[i]);//给对象的该字段设置结果集合中对应的值
				}/* catch (SQLException e) {
					// TODO 此处省略记录日志
//					System.out.println("**********警告信息：结果结合中没有对象属性的值 -->"+fieldNames[i]);
				}*/ catch (IllegalArgumentException e) {//值类型与参数类型不匹配
//					e.printStackTrace();//数据库无符号int查出后类型超出java int范围,所以为Long类型,会产生类型转换异常
					try {
						//处理无符号int即Long类型设置给int字段的类型转换异常
						fields[i].set(object, value instanceof Long ?Integer.parseInt(Long.toString((Long)value)):value);
					} catch (NumberFormatException e1) {
						System.err.println("请检查Jpa原生SQL语句的结果集字段顺序与实体类字段顺序是否完全一致");
						e1.printStackTrace();						
					} catch (IllegalArgumentException e1) {
						System.err.println("请检查Jpa原生SQL语句的结果集字段顺序与实体类字段顺序是否完全一致");
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						System.err.println("该实体类字段值不可设置,请检查你的实体类字段及访问修饰符权限.");
						e1.printStackTrace();
					}//给对象的该字段设置结果集合中对应的值										
				} catch (IllegalAccessException e) {
					System.err.println("该实体类字段值不可设置,请检查你的实体类字段及访问修饰符权限.");
					e.printStackTrace();
				}
//			System.out.println("所有字段的值 "+value);
			}
			list.add(object);
			
		}
		return (T) list;
	}
	
	
	

}
