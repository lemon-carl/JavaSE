package com.lh.variable;

/**
 * @Description: 静态变量和成员变量
 *@Name : VariableTest
 *@Author : LH
 *@Date : 2018-6-1下午10:00:51
 *@Version : V1.0
 * 
 *
 */
public class VariableTest {

	public static int staticVar = 0;
	public int instanceVar = 0;
	public VariableTest() {
           staticVar++;
           instanceVar++;
           System.out.println("staticVar=" + staticVar  +  ",instanceVar=" + instanceVar);
	 }
	public static void main(String[] args) {
		VariableTest test = new VariableTest();
		VariableTest test2 = new VariableTest();
		VariableTest test3 = new VariableTest();
		VariableTest test4 = new VariableTest();

		System.out.println(test.instanceVar);
		System.out.println(test2.instanceVar);
		System.out.println(test3.instanceVar);
		System.out.println(test4.instanceVar);
           
		System.out.println(VariableTest.staticVar);
	}
}
