package com.lh.variable;

import java.util.Date;

@SuppressWarnings("serial")
public class Test_className extends Date{

	public static void main(String[] args) {
             new Test_className().test();
	}
	
	public void test(){
		//返回方法的所属类
		System.out.println(super.getClass().getName());
		//返回本类的父类
		System.out.println(getClass().getSuperclass().getName());
	}

}
