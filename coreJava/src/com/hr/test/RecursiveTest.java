package com.hr.test;

import org.junit.Test;

/**
 * 
 *
 *@Name : RecursiveTest
 *@Author : LH
 *@Date : 2018-12-11下午05:42:12
 *@Version : V1.0
 *@Description:  阶乘递归测试
 *  阶乘介绍：一个正整数的阶乘是所有小于及等于该数的正整数的积，并且有0的阶乘为1。自然数n的阶乘写作n!
   *   　阶乘函数是递归函数典型示例。
 *  阶乘的实现方法（一种递归，两种循环）：　　　　
 */
public class RecursiveTest {
	
		
		@Test
		public void forTest(){
			int num =0;
			//num = Recursive.factorial(6);
			//num = Recursive.fordigui(6);
		    num = Recursive.whileDiGui(6);
			// num = Recursive.factorial(6, 1);
			System.out.println("递归："+num);
			
		}
}
