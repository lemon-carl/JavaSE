package com.ann.bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {

	    public static void main(String[] args) {
			//1.使用类加载器加载类
	    	try {
				Class c  = Class.forName("com.ann.bean.Child");
				//2.找到了上面的注解
				 boolean isExist = c.isAnnotationPresent(Description.class);
	    	     if(isExist) {
	    	    	 //3.拿到注解实例
	    	    	 Description d = (Description) c.getAnnotation(Description.class);
	    	         System.out.println(d.value());
	    	     }
	    	     
	    	     //4.找到方法上的注解
	    	     //方法一
	    	     Method []  ms = c.getMethods();
	    	     for (Method m : ms) {
					  boolean isMExist = m.isAnnotationPresent(Description.class);
					  if(isMExist) {
						  Description d  = m.getAnnotation(Description.class);
						  System.out.println(d.value());
					  }
	    	 	}	  
					  //方法二
					  for (Method m2 : ms) {
						Annotation [] ann = m2.getAnnotations();
						for (Annotation at : ann) {
							if(at instanceof Description) {
								Description d = (Description) at;
								System.out.println(d.value());
							}
						}
	    	     }
	    	     
	    	} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
}
