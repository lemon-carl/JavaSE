package com.hr.zzbds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 *@Name : RegExpTest
 *@Author : LH
 *@Date : 2018-3-23下午04:34:17
 *@Version : V1.0
 * @Description: 如何从字符串中截取第一个英文左括号之前的字符串，例如：  北京市(朝阳区)(东城区)(海淀区)，
 * 截取结果为北京市，正则表达式怎么写？
 *
 */
public class RegExpTest {

	@Test
	public void regTest(){
	    /* String str ="北京市(朝阳区)(东城区)(海淀区)";
	     Pattern p = Pattern.compile(".*?(?=\\()");*/
	     String str ="北京市(朝阳区)[东城区)(海淀区)";
	     Pattern p = Pattern.compile(".*?(?=\\[)");
	     Matcher m = p.matcher(str);
	     if(m.find()){
	    	 System.out.println(m.group());
	     }
	}
}
