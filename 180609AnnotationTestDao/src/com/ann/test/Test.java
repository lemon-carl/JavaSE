package com.ann.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ann.bean.Filter;
import com.ann.bean.Filter2;
import com.ann.util.Column;
import com.ann.util.Table;

/**
 *   注解项目实战
 * @Name  : Test
 * @Author : LH
 * @Date : 2018年6月9日 下午12:43:25
 * @Version : V1.0
 * 
 * @Description : 
 *        项目说明： 项目取自一个公司的持久层架构，用来代替hibernate的解决方案，核心代码通过注解来实现。
 *        需求：1、有一张用户表，字段包括用户id，用户名，昵称，年龄，性别，所在城市，邮箱，手机号。
 *                 2、方便的对每个字段或字段的组合条件进行检索，并打印SQL。
 *                 3.使用方式要足够简单，代码示例如下。
 *              
 */
public class Test {
	
	 			public static void main(String[] args) {
					Filter f1 = new Filter();
					f1.setId(10);//查询id为10 的用户
					
					Filter f2 = new Filter();
					f2.setUserName("luck");//查询用户名为“luck”的用户
					f2.setAge(18);
					
					Filter f3 = new Filter();
					//f3.setEmail("carl@sina.com,ksana@sina.com,zh@163.com");//查询邮箱为其中任意一个的
					f3.setEmail("carl@sina.com");//查询邮箱为其中任意一个的
				
	 			   String sql1 = query(f1);
	 			   String sql2 = query(f2);
	 			   String sql3 = query(f3);
	 			   
	 			   System.out.println(sql1);
	 			   System.out.println(sql2);
	 			   System.out.println(sql3);
	 			   
	 			   Filter2 filter2 = new Filter2();
	 			   filter2.setAmount(10);
	 			   filter2.setName("开发部");
	 			   System.out.println(query(filter2));
	 			}
	 			
	 			private static String query(Object filter) {
	 				StringBuilder sb = new StringBuilder();
	 				//1.获取class
	 				Class c = filter.getClass();
	 				//2.获取table的名字
	 				boolean exists = c.isAnnotationPresent(Table.class);
	 				if(!exists) {
	 					return null;
	 				}
	 				
	 				Table table =   (Table) c.getAnnotation(Table.class);
	 				String tableName = table.value();
	 				//System.out.println(tableName);
	 				sb.append("select * from ").append(tableName).append(" where 1=1 ");
	 				//3.遍历所有字段
	 				Field [] fs = c.getDeclaredFields();
	 				 //4.处理每个字段对应的sql
	 				for (Field field : fs) {
	 					 //4.1、拿到字段名
	 					boolean fExists =  field.isAnnotationPresent(Column.class);
	 					if(!fExists) {
	 						continue;
	 					}
						Column column = field.getAnnotation(Column.class);
						String columnName = column.value();
						//System.out.println(columnName);
	 					//4.2拿到字段值
						String fieldName = field.getName();
						String getMethodName = "get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	 					
						Object fieldValue = null;
						try {
							Method getMethod = c.getMethod(getMethodName);
							fieldValue = getMethod.invoke(filter);
						} catch (Exception e) {
							e.printStackTrace();
						}
						//4.3拼装sql
						if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue ==0 )) {
							continue;
						}
						sb.append(" and ").append(fieldName);
						if(fieldValue instanceof String ) {
							if(((String) fieldValue).contains(",")) {
								String [] values = ((String) fieldValue).split(",");
							    sb.append(" in (");
							    for (String v : values) {
									sb.append("'").append(v).append("'").append(",");
								}
							    sb.deleteCharAt(sb.length()-1);
							    sb.append(")");
							}else {
								sb.append(" = ").append("'").append(fieldValue).append("'");
							}
						}else if(fieldValue instanceof Integer) {
							sb.append(" = ").append(fieldValue);
							
						}
	 				}
	 				
	 				return sb.toString();
	 			}
}
