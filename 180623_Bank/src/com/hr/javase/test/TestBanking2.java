package com.hr.javase.test;

import com.hr.javase.bank2.Account;
import com.hr.javase.bank2.Customer;

/**
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 * @Name  : TestBanking2
 * @Author : LH
 * @Date : 2018年7月2日 下午10:56:53
 * @Version : V1.0
 * @Description :
 * 实验题目 2： ：
 * 扩展银行项目，添加一个 Customer 类。Customer 类将包含一个 Account对象。
 * 实验目的： ：
 * 使用引用类型的成员变量。
 * 
 * 输出结果:
 * Creating the customer Jane Smith.
 * Creating her account with a 500.00 balance.
 * Withdraw 150.00
 * Deposit 22.50
 * Withdraw 47.62
 * Customer [Smith, Jane] has a balance of 324.88
 */
public class TestBanking2 {

		  public static void main(String[] args) {
			  	Customer customer;
			  	//Account  account;
		
		    // Create an account that can has a 500.00 balance.
		    System.out.println("Creating the customer Jane Smith.");
		    //code
		    customer = new Customer("Jane", "Smith");
		    
		    System.out.println("Creating her account with a 500.00 balance.");
		    //code
		    customer.setAccount(new Account(500.0));
		    
		    System.out.println("Withdraw 150.00");
			//code
		    customer.getAccount().withdraw(150.00);
		    
		    System.out.println("Deposit 22.50");
		  	//code
		    customer.getAccount().deposit(22.5);
		    
		    System.out.println("Withdraw 47.62");
		   	//code
		    customer.getAccount().withdraw(47.62);
		    
		    // Print out the final account balance
		    System.out.println("Customer [" + customer.getLastName()
				       + ", " + customer.getFirstName()
				       + "] has a balance of " + customer.getAccount().getBalance());
		  }
}
