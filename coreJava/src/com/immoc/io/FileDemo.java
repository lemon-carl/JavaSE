package com.immoc.io;

import java.io.File;
import java.io.IOException;

/**
 *  File 文件目录编码创建操作
 *@Description:
 *@Name : FileDemo
 *@Author : LH
 *@Date : 2018-6-1下午10:39:01
 *@Version : V1.0
 *
 */
public class FileDemo {

     public static void main(String[] args) {
		File file = new File("F:\\imooc");
		//System.out.println(file.exists());
		if(!file.exists()){
			file.mkdir();
		}else{
			file.delete();
		}
		//是否是一个目录，如果是目录返回true，如果不是目录或目录不存在返回false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
		//File file2 =new File("f:\\imooc\\日记1.txt");
		File file2 = new File("f:\\imooc\\","日记1.txt");
		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			file2.delete();
		}
		System.out.println(file);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
	}
}
