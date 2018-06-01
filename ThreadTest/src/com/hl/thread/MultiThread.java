package com.hl.thread;

/**
 * 多线程实现运行
 *@Description:
 *@Name : MultiThread
 *@Author : LH
 *@Date : 2018-6-1下午11:30:57
 *@Version : V1.0
 *
 */
public class MultiThread {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
                   new Thread(new Thread1()).start();
                    try {
					  Thread.sleep(10);
			     	} catch (Exception e) {
                          e.printStackTrace();
			     	}
                    new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable{

		@Override
		public void run() {
			        synchronized (MultiThread.class) {
						   System.out.println("enter thread1...");
						   System.out.println("thread1 is waiting");

						   try {
							  MultiThread.class.wait();
						   } catch (Exception e) {
                               e.printStackTrace(); 
						   }
						   
						   System.out.println("thread1 is going on ......");
						   System.out.println("thread1 is being over !");
					}
		}
		      
	}
	private static class Thread2 implements Runnable{
		
		@Override
		public void run() {
			synchronized (MultiThread.class) {
				System.out.println("enter thread2...");
				System.out.println("thread2 notify other thread can release wait status...");
				MultiThread.class.notify();
				System.out.println("thread2 is sleeping ten millisecond...");
				try {
                      Thread.sleep(10);
                } catch (Exception e) {
					e.printStackTrace(); 
				}
				
				System.out.println("thread2 is going on ......");
				System.out.println("thread2 is being over !");
			}
		}
		
	}
	
	
	
}
