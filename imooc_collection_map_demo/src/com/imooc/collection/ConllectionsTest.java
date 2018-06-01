package com.imooc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1.通过Conllections.sort()方法，对Integer泛型的List进行排序
 * 2.对String泛型的List进行排序
 * 3.对其他类型泛型的list进行排序，以Student为例
 * @author LH
 *
 */
public class ConllectionsTest {

	   /**
	    * 1.通过Conllections.sort()方法，对Integer泛型的List进行排序
	    * 创建一个Integer泛型的List，插入十个100以内的不重复随机整数，
	    * 调用Collections.Sort()方法对其进行排序
	    */
	public void testSort1(){
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内的不重复随机整数，
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do{
				k = random.nextInt(100);
			}while(integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("-------------排序前--------------------");
	    for (Integer integer : integerList) {
			System.out.println("元素：" + integer);
		}
	    Collections.sort(integerList);
        System.out.println("==========排序后=========");
        for (Integer integer : integerList) {
		    System.out.println("元素： " +integer);
	    }
	}
	
	/**
	 * 2.对String泛型的List进行排序
     *创建String泛型的List，添加三个乱序的String元素
     *调用sort方法，再次输出排序后的顺序
	 */
   public void testSort2(){
	   List<String> stringList = new ArrayList<String>();
	   stringList.add("microsoft");
	   stringList.add("google");
	   stringList.add("lenovo");
	   System.out.println("-------------排序前--------------------");
       for (String string : stringList) {
		System.out.println("元素：" + string);
	  }
       Collections.sort(stringList);
	   System.out.println("-------------排序后--------------------");
	   for (String string : stringList) {
		   System.out.println("元素：" + string);
	   }
	   
   }
   
   /**
    * 3.对其他类型泛型的list进行排序，以Student为例
    */
   public void testSort3(){
	   List<Student> list = new ArrayList<Student>();
	   Random ran = new Random();
	   list.add(new Student(ran.nextInt(1000)+"","Make"));
	   list.add(new Student(ran.nextInt(1000)+"","Jack"));
	   list.add(new Student(ran.nextInt(1000)+"","Carl"));
	   list.add(new Student(10000 +"","Beyaon"));
	   System.out.println("-------------排序前--------------------");
	   for (Student student : list) {
		System.out.println("学生："+student.id+"::" +student.name);
	   }
	   Collections.sort(list);
	   System.out.println("-------------排序后--------------------");
	   for (Student student : list) {
			System.out.println("学生："+student.id+"::" +student.name);
	   }
	   
	   Collections.sort(list,new StudentComparator());
	   System.out.println("-------------按照姓名排序后-----------");
	   for (Student student : list) {
		   System.out.println("学生："+student.id+"::" +student.name);
	   }
	   
   }
	
	
	public static void main(String[] args) {
               ConllectionsTest ct= new ConllectionsTest();
                ct.testSort1();
                ct.testSort2();
                ct.testSort3();
	}

}
