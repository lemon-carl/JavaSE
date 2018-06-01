package com.hr.demo;

/**
 * 单例模式：
 * @author LH
 *
 */
public class Singleton {

	/**
	 * 饿汉式
	 */
	/* 
	   private static Singleton instance = new Singleton();
	   private Singleton(){}
	   public static Singleton getInstance(){
		   return instance;
	   }*/
	
	/**
	 * 懒汉式
	 */
		
	   private static Singleton instance= null;
	   private Singleton(){}
	   public static synchronized Singleton getInstance(){
		   if (instance == null){
			   instance = new Singleton();
		   }
		   return instance;
	   }
	   
	
}
