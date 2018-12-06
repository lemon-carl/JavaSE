package com.hr.test;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class MaoPaoArrayTest {

	  
		/**
		 * 冒泡排序求最大和最小的差		
		 */
	   @Test
	   public void testArray1(){
		     Scanner input = new Scanner(System.in);
			  int [] arry = new int [5];
			  for (int i = 0; i < arry.length ; i++) {
				  arry[i] = input.nextInt();
			  }
		  // int [] arry = {2,5,1,9,6,4};
		   int max;
		   for (int i = 0; i < arry.length; i++) {
			    for (int j = 0; j < arry.length-1; j++) {
					if(arry[j] < arry[j+1]){
						max =arry[j+1];
						arry[j+1] = arry[j];
						arry[j]=max;
					}
				}
		   }
		  /* for (int i = 0; i < arry.length; i++) {
			    System.out.println(arry[i]);
		   }*/
		   int cha = arry[0] - arry[arry.length-1];
		   System.out.println("最大值和最小值的差：" + cha);
		   
	   }
	   /**
	    * 数组排序
	    * Java.util.Arrays类的 sort() 方法提供了数组元素排序功能
	    */
	   @Test
	   public void testArray2(){
		   Scanner input = new Scanner(System.in);
		   int [] arry = new int [5];
		   for (int i = 0; i < arry.length ; i++) {
			  arry[i] = input.nextInt();
		  }
		   
		//   int [] arry = {2,5,1,9,6,4};
		   Arrays.sort(arry);
		   for (int i = 0; i < arry.length; i++) {
			   	System.out.println(arry[i]);
		   }
		   
		   int cha = arry[arry.length-1] - arry[0];
		   System.out.println("最大值和最小值的差：" + cha);
		   
	   }
	   
	   
	   /**
	    * java二维数组求和算法
		*急求一个int[] [] rr=new int[][3] 这样一个3列的二维数组求和算法，要求第一列不相加 第二列整列相加，
		*第三列跟第二列一样，第一列相当一表示，跟Map里面的Key一样
		*
		*n*n二维数组求和
	    */
	   @Test
	   public void testArray3(){
		   int [][]a = {{1,2,4,5},{6,7,8,9},{10,11,12,13},{14,15,16,17}};
		   int sum  =0; //设置sum为0，方便计算
		    //双层循环计算二维数组
		   for(int i = 0; i < a.length; i++) { 
			   for(int j = 0; j < a[i].length ;j++){
				   // 二维数组求和去除此判断
				   //if(i >= 2){
				   	sum = sum+ a[i][j];
				   //}
			   }
		   }
		   		//输出结果
		     System.out.println(sum); 
	}
	   /**
	    * java二维数组算法
	    *求二维数组最大值所在的列和行。
	    */
	   @Test
	   public void testArray4(){
		   int [][]a = {{1,2,4,5},{6,7,8,9},{10,11,12,13},{14,15,16,17}};
		   int row = 0 ,colum = 0; 
		   int max =a[0][0];
		   //双层循环计算二维数组
		   for(int i = 0; i < a.length; i++) { 
			   for(int j = 0; j < a[i].length ;j++){
				   // 二维数组求和去除此判断
				   if(a[i][j] > max){
					   max = a[i][j];
					   row = i+1;
					   colum =j+1 ;
				   }
				   
			   }
		   }
		   //输出结果
		   System.out.println("max=" +max +",row=" +row +",colum="+colum);
		   /*运行结果如下： 
		   ---------------------------------------------------------- 
		   max=10, 
		   row = 2,3 
		   colum = 1 ,2
		   ---------------------------------------------------------- 
		   */   
	   }
		
	   
	   
	 
	   
	   
}
