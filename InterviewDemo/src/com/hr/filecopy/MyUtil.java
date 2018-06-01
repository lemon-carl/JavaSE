package com.hr.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import com.sun.corba.se.impl.ior.ByteBuffer;

/**
 * 
 *@Name : MyUtil
 *@Author : LH
 *@Date : 2018-3-22下午05:27:57
 *@Version : V1.0
 * @Description: 69、编程实现文件拷贝
 */
public class MyUtil {

	private MyUtil() {
      throw new AssertionError();
	}

	public static void fileCopy(String source,String target) throws IOException{
		
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(source);
			out = new FileOutputStream(target);
			
			
			byte [] buffer = new byte[4096];
			int bytesToRead;
			while((bytesToRead = in.read(buffer)) !=-1){
				out.write(buffer,0,bytesToRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
				try {
					if(out != null){
					 out.close();
					}
					if(in != null){
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
			
		
	}

	
}
