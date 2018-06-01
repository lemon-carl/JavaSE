package com.immoc.io;

/**
 * 
 *
 *@Description: 字节编码 code
 *
 *@Name : EncodeDemo
 *@Author : LH
 *@Date : 2018-6-1下午10:36:11
 *@Version : V1.0
 *
 */
public class EncodeDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = "慕课ABC";
		byte [] bytes1 = s.getBytes();//转换成字节序列用的是项目默认的编码gbk
		for (byte b : bytes1) {
			//把字节（转换成int）以16进制的方式显示
			   System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		byte [] byte2 = s.getBytes("gbk");
		//gbk 编码中文占用两个字节，英文占用1个字节
		for (byte b : byte2) {
			System.out.print(Integer.toHexString(b & 0xff)+ " ");
		}
		System.out.println();
		byte [] byte3 = s.getBytes("utf-8");
		//utf-8 编码中文占用三个字节，英文占用1个字节
		for (byte b : byte3) {
			System.out.print(Integer.toHexString(b & 0xff)+ " ");
		}
		
		//java是双字节编码 utf-16be
		byte [] byte4 = s.getBytes("utf-16be");
		//utf-16be 中文占用2个字节 英文占用2个字节
		for (byte b : byte4) {
			System.out.print(Integer.toHexString(b & 0xff)+ " ");
		}
		System.out.println();
		/*
		 * 当你的字节序列式某种编码时，这个时候想把字节序列变成
		 * 字符串，也需要这种编码方式，否则会出现乱码
		 * 		 
		 * */
       String str1 =new String(byte4);//项目默认的编码
       System.out.println(str1);
       String str2 = new String(byte4,"utf-16be");
       System.out.println(str2);
       String str3 = new String(byte3,"utf-8");
       System.out.println(str3);
       /*
        * 文本文件 就是字节序列
        * 如果是任意编码的字节序列
        * 如果我们在中文机器上直接创建文本文件，该文本文件只认识ansi编码
        * 联通，联这是一种巧合，它们正好符合utf-8编码的规则
        */
	}

}
