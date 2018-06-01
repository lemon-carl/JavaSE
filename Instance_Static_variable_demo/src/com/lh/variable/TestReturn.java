package com.lh.variable;

public class TestReturn {

	public static void main(String[] args) {
           System.out.println(new TestReturn().test());
	}
	static int test(){
		int x =1;
		try {
			return x; //1
		} finally{
			++x;
		}
		
	}

}
