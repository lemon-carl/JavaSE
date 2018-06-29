package com.hr.java;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * @Name  : StringTest180619
 * @Author : LH
 * @Date : 2018年6月29日 下午3:35:48
 * @Version : V1.0
 * 
 * @Description :  
 *    		  1、功能：压缩字符串(aaabbccc --> a3b2c3)
 *           2、功能：求主串中字符子串的位置以后的子串(fffggbbckkll bbc --> bbckkll)
 *           3、功能：倒数m个字符，移动字符串(ABCDEFGHI，M=3 --> GHIABCDEF)
 */
public class StringTest180619 {

					
					@Test
					public void test1() {
						Scanner scann = new Scanner(System.in);
						String s = scann.nextLine();
					//	String d = compressStr(s);
					//	System.out.println(d);
					//	System.out.print(d.length());

					//	System.out.println(strstrp(s,"bbc"));
						
						System.out.println(moveStr(s, 5));
						
			    	}
			
					/**
					 * 1、功能：压缩字符串(aaabbccc --> a3b2c3)
					 * @param String:s 
					 * @return 
					 */
					public static String compressStr(String s){
						char[] c = s.toCharArray();
						for (char d : c) {
							System.out.print(" " + d +",");
						}
						char[] tmp = new char[2*c.length];
						System.out.println("tmp="+tmp.length);
						tmp[0] = c[0];
						int j=1,k=1;
						for(int i=1;i<c.length;i++){
							if(c[i] != c[i-1]){
								//把相同字符后面不同的第一个字符，以及后面所有的字符在转为cahr数组
								char[] ktmp = String.valueOf(k).toCharArray();
								for(int t=0; t<ktmp.length; t++){
									tmp[j]= ktmp[t];
									j++;
								}
								tmp[j] = c[i];
								k=1;				
								j++;
							}else{
								k++;
								continue;
							}
						}
						char[] ktmp = String.valueOf(k).toCharArray();
						for(int t=0; t<ktmp.length; t++){
							tmp[j]= ktmp[t];
							j++;
						}
						String newstr = String.valueOf(tmp, 0, j);
						return newstr;
					}
					
					/**
					 * 2、功能：求主串中字符子串的位置以后的子串(fffggbbckkll bbc --> bbckkll)
					 * @param Stirng:str
					 * @param String:sub
					 * @return 
					 */
					public static String strstrp(String str,String sub){
						for(int i=0; i<str.length();i++){
							int j=0;
							int tmp=i;
							if(str.charAt(i)==sub.charAt(j)){
								while(str.charAt(i)==sub.charAt(j)){
									if(sub.length()==(j+1))
										return str.substring(i-j);
									i++;
									j++;
								}
								i=tmp;
							}
						}
						return null;
					}

					
					/**
					 * 3、功能：倒数m个字符，移动字符串(ABCDEFGHI，M=3 --> GHIABCDEF)
					 * @param ss
					 * @param M
					 * @return
					 */
					public static String moveStr(String ss,int M){
						char[] s = ss.toCharArray();
						int i = 0;
						char tmp;
						int len = s.length;
						if(M>len) M = len;
						while(len>M){
							for(i=0,tmp=s[0],M++;i<len-1;i++){ //整个字符左移一次
								s[i] = s[i+1];
							}
							s[len-1]=tmp;
						}
						String news = String.valueOf(s);
						return news;
					}


}
