package com.hr.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 *@Name : TestCallable
 *@Author : LH
 *@Date : 2018-3-22œ¬ŒÁ12:37:02
 *@Version : V1.0
 * @Description: ≤‚ ‘¿‡
 */
public class TestCallable {

	public static void main(String[] args) throws Exception {
	    List<Future<Integer>> list = new ArrayList<Future<Integer>>();	
	    ExecutorService service = Executors.newFixedThreadPool(10);
	    for (int i = 0; i < 10; i++) {
			list.add(service.submit(new MyTask((int)(Math.random()*100))));
		}
	    
	    int sum = 0;
	    for (Future<Integer> future : list) {
			while (!future.isDone());
			sum += future.get();
		}
	    
	    System.out.println(sum);
	}
}
