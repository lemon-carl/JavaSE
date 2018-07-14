/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */
package com.hr.javase.test;

import com.hr.javase.bank1.Account;

/**
 * 
 * @Name  : TestBanking1
 * @Author : LH
 * @Date : 2018年7月2日 下午10:50:12
 * @Version : V1.0
 * @Description :
 * 实验题目 1： ：
 * 创建一个简单的银行程序包
 * 实验目的： ：
 * Java 语言中面向对象的封装性及构造器的创建和使用。
 * 实验说明： ：
 * 在这个练习里，创建一个简单版本的 Account 类。将这个源文件放入 banking 程
 * 序包中。在创建单个帐户的默认程序包中，已编写了一个测试程序 TestBanking。
 * 这个测试程序初始化帐户余额，并可执行几种简单的事物处理。最后，该测试程 序
 * 显示该帐户的最终余额
 * 
 * 输出结果：
 * Creating an account with a 500.00 balance
 * Withdraw 150.00
 * Deposit 22.50
 * Withdraw 47.62
 * The account has a balance of 324.88
 * 
 */
public class TestBanking1 {

			  public static void main(String[] args) {
			       Account  account;
			
			    // Create an account that can has a 500.00 balance.
			    System.out.println("Creating an account with a 500.00 balance.");
			
			    //code
			    account = new Account(500.0);
			    
			    System.out.println("Withdraw 150.00");
			   	//code
			    account.withdraw(150.00);
			    
			    System.out.println("Deposit 22.50");
				//code
			    account.deposit(22.50);
			    
			    System.out.println("Withdraw 47.62");
			   	//code
			    account.withdraw(47.62);
			    
			    // Print out the final account balance
			    System.out.println("The account has a balance of " + account.getBalance());
			  }
}
