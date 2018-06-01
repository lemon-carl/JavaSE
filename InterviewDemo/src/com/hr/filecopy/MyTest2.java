package com.hr.filecopy;

import org.junit.Test;


public class MyTest2 {

	
	@Test
	public void testMain(){
	   
		String filename= "F:\\dir\\ABC.txt";
		String word ="a";
		int  count= MyUtil2.countWordInFile(filename, word);
	
		System.out.println("字符串在文件中出现的次数:"+count);
	}
}
