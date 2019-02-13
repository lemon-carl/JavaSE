package com.hr.test;

/**
 * 
 *@Name : Recursive
 *@Author : LH
 *@Date : 2018-12-11下午05:42:12
 *@Version : V1.0
 *@Description:  阶乘递归测试
 *  阶乘介绍：一个正整数的阶乘是所有小于及等于该数的正整数的积，并且有0的阶乘为1。自然数n的阶乘写作n!
   *   　阶乘函数是递归函数典型示例。
 *  阶乘的实现方法（一种递归，两种循环）：　　　　
 */
public class Recursive {
	
	/**
	 * 方法1：递归
	 * @param num
	 * @return
	 */
	public static int factorial(int num){
		if(num <0){
			return -1;
		} else if(num ==0 || num ==1){
			return 1;
		} else {
			return (num* factorial(num - 1));
		}
		
	}
	
	/**
	 * 方法2：for循环
	 * @param num
	 * @return
	 */
	public static int fordigui(int num){
		if(num < 0){
			return -1;
		} else if (num == 0 || num ==1){
			return 1;
		} else {
			for (int i = num -1 ; i >= 1; i--) {
				num *= i;
			}
		}
		return num;
	}
	
	/**
	 * 方法3：while循环
	 * @param num
	 * @return
	 */
	public static int whileDiGui(int num) { 
	    int result = num; 
	    if (num < 0) { 
	        return -1; 
	    } else if (num == 0 || num == 1) { 
	        return 1; 
	    } else { 
	        while (num > 1) { 
	            num--; 
	            result *= num; 
	        } 
	    } 
	    return result; 
	};

	/**
	 * 方法4：尾递归
	 * @param n
	 * @param total
	 * @return
	 */
	public static int factorial(int n,int total){
		if(n == 1) return total;
		return factorial(n-1, n*total);
	}

}
