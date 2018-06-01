package com.huawei.interview;


import org.junit.Test;

public class TestNode {

	@Test
	public void test() {
	            int [] data = new int[20];
	            for (int i = 0; i < data.length; i++) {
					       data[i] = (int) ((Math.random()*100) +1);
					       System.out.println(data[i] + ",");
				}
	            System.out.print("");
	            
	            Node root = new Node();
	            root.value = data[0];
	            for (int i = 1; i < data.length; i++) {
					  root.store(data[i]);
				}
	            
	           root.find(data[19]);
	           root.preList();
	          System.out.print("");
	          root.middleList();
	          System.out.print("");
	          root.afterList();
	}

}
