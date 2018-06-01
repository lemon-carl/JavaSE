package com.imooc.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *@Name : Student
 *@Author : LH
 *@Date : 2018-6-1下午05:41:03
 *@Version : V1.0
 * 
 *@Description: 学生类
 */
public class Student {

	public String id;
	
	public String name;
	
	public Set<Course> courses;

	public Student(String id, String name){
	   this.id = id;
	   this.name = name;
	   this.courses =new HashSet<Course>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
   
   

}
