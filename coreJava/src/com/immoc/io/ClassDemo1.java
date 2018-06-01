package com.immoc.io;

/**
 * 反射
 *@Description:
 *@Name : ClassDemo1
 *@Author : LH
 *@Date : 2018-6-1下午10:41:27
 *@Version : V1.0
 *
 */
public class ClassDemo1 {

	public static void main(String[] args) {
          
		Foo  foo1 = new Foo();
		//然后一个类都是Class的实例对象
		
		//任何一个类都有一个隐含的静态成员
		Class c1  = Foo.class;
		
		//该类的对象通过getClass方法
		Class c2 =foo1.getClass();
		
		System.out.println(c1 == c2);
		
		Class c3 = null;
		try {
			c3 = Class.forName("com.immoc.io.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);
	}

}

class Foo{}