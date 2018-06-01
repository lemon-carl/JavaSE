package com.hr.test;

public class Test {

	public static void main(String[] args) {
		int i=12;
		System.out.println(i+=i-=i*=i);
		//i*=i 12*12 =144
		//i-=i 12-144 = -132
		//i+-i 12-132 = -120
		
		assert(i > 0);
		
		System.out.println(reverse("12345"));
	}

	public static String reverse(String str) {
	    if(str == null || str.length() <= 1)
	    	return str;
	    	
	    //返回一个从指定位置开始，并具有指定长度的子字符串。
	  /*　参数str.substr(start,length); //
	  　　start必选。所需的子字符串的起始位置。字符串中第一个字符的索引为 0。
	  　　length可选项。返回的子字符串中包含的字符数。*/
	   /* charAt(int index)方法是一个能够用来检索特定索引下的字符的String实例的方法.
	    charAt()方法返回指定索引位置的char值。索引范围为0~length()-1.
	    如: str.charAt(0)检索str中的第一个字符,str.charAt(str.length()-1)检索最后一个字符.*/
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	
	
}
