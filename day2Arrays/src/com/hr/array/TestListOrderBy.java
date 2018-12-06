package com.hr.array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hr.entity.Student;


public class TestListOrderBy {

	
	 /**
	  * (1)使用冒泡排序算法
	  * 由于题目要求是按照学生的成绩排序，因此，在遍历集合元素时要根据年龄进行比较，并交换集合中相应元素的值。
	  * 实现的代码如下所示。
	  */
	  @Test
	  public void testStudent(){
		  List<Student> list = new ArrayList<Student>();
		  list.add(new Student(1,"小张",20,98));
		  list.add(new Student(2,"小王",18,99));
		  list.add(new Student(3,"小李",19,96));
		  //使用冒泡排序算法
		  for(int i=0; i< list.size()-1;i++){
			  for(int j=0; j<list.size()-1-i;j++){
				  if(list.get(j).getScore()>list.get(j+1).getScore()){
					  Student student=list.get(j);
					  list.set(j, list.get(j+1));
					  list.set(j+1, student);
				  }
			  }
		  }
		  
		  for(Student stu:list){
		  System.out.println(stu);
		  }
	  }
	
}
