package com.hr.array;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 *@Name : TestDiGui
 *@Author : LH
 *@Date : 2018-7-11上午09:54:25
 *@Version : V1.0
 *@Description:    
 */
public class TestDiGui {

	   /**
	    *  (1+2+...n)/(1*2*.....n)
	    */
	   @Test 
	   public void test1(){
		      Scanner input = new Scanner(System.in);
		      
		      double number = input.nextDouble();
		      double num =0,num2=1;
		      for (int i = 1; i <= number; i++) {
				  num +=i; 
				  num2 *=i; 
			  }
		      System.out.println("递归和除以递归积：" + (num/num2));
		      double rownum = (num/num2);
		      System.out.println("递归和除以递归积：" + 
		    		  new DecimalFormat("#,##0.000000").format(new Double(rownum)));

	   }
	   
	   /**
	    * 计算1/1+1/(1+2)+1/(1+2+3)+...+1/(1+2+...+n)的值，结果保留6位。
	    */
	   @Test
	   public void test2(){


		   Scanner input = new Scanner(System.in);
		      
		   int n = input.nextInt();
		   
		   double s =0,sum=0;
		   for (int j = 1; j <= n; j++) {
			   sum += j;
			   s += 1.00000/sum;
		   }
		   
		   System.out.println("结果：" +s);
		   System.out.println("Double :" +
				   new DecimalFormat("#,##0.000").format(new Double(s)));
	   }
	
}
