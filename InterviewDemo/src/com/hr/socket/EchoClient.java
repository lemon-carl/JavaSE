package com.hr.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 *@Name : EchoClient
 *@Author : LH
 *@Date : 2018-3-22下午07:00:53
 *@Version : V1.0
 * @Description: 回显客户端
 */
public class EchoClient {

	public static void main(String[] args) throws Exception {
		 Socket client = new Socket("localhost",6789);
	     Scanner  sc = new Scanner(System.in);
	     System.out.println("请输入内容：");
	     String msg = sc.nextLine();
	     sc.close();
	     
	     PrintWriter pw = new PrintWriter(client.getOutputStream());
	     pw.println(msg);
	     pw.flush();
	     
	     BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
	     System.out.println(br.readLine());
	     client.close();
	     
	     
	}
	
}
