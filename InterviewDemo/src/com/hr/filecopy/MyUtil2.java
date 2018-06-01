package com.hr.filecopy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 *@Name : MyUtil2
 *@Author : LH
 *@Date : 2018-3-22下午06:02:27
 *@Version : V1.0
 * @Description: 71、写一个方法，输入一个文件名和一个字符串，统计这个字符串在此文件中出现的次数。
 */
public class MyUtil2 {

	/**
	 * 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象
	 */
	private MyUtil2(){
		throw new AssertionError();
	}
	
	/**
	 * 统计给定的文件中给定字符串出现的次数
	 *  
	 * @param filename
	 * @param word
	 * @return 字符串在文件中出现的次数
	 */
	public static int countWordInFile(String filename,String word){
		int counter = 0;
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null){
				int index =-1;
				while(line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
					counter ++;
					line = line.substring(index + word.length());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}
}
