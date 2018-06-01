package com.lh.variable;
/**
 * 
 *@Name : Test
 *@Author : LH
 *@Date : 2018-6-1下午09:46:38
 *@Version : V1.0
 * 
 *@Description: 测试try{}里有一个return语句，后面的finally里代码会不会执行，什么时候执行，在return前还是之后
 *结果  "func1(),func2(),2"
 */
public class Test {

	public static void main(String[] args) {
            System.out.println(new Test().test());
	}

	int test(){
		try{
			return func1();
		}finally{
			return func2();
		}
	}



	private int func1() {
		System.out.println("func1");
		return 1;
	}
	
	private int func2() {
		System.out.println("func2");
		return 2;
	}
}
