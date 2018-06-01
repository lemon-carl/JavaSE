package com.hr.thread;

import java.util.concurrent.Callable;

/**
 * 
 *@Name : MyTask
 *@Author : LH
 *@Date : 2018-3-22下午12:32:54
 *@Version : V1.0
 * @Description:java1.5后创建线程第三种方式：实现Callable接口，该接口中的call方法可以
 * 在线程执行结束时产生一个返回值。
 */
public class MyTask implements Callable<Integer> {

	private int upperBounds;
	
	
	public MyTask(int upperBounds) {
		this.upperBounds = upperBounds;
	}


    public Integer call() throws Exception {
		int sum = 0;
		for (int i = 1; i <= upperBounds; i++) {
			sum += i;
		}
		
		return sum;
	}

}
