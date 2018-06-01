package com.lh.variable;

public class AssertTest {

	public static void main(String[] args) {

		  int i;
		  for ( i = 0; i < 5; i++) {
			   System.out.println(i);
		  }
		  --i;
		  assert i ==5;
	}
}
