package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import com.hr.javase.bank3.Account;
import com.hr.javase.bank3.Customer;


/**
 * 
 * @Name  : TestBanking3
 * @Author : LH
 * @Date : 2018年7月2日 下午11:17:59
 * @Version : V1.0
 * @Description :
 * 
 * 实验题目 3： ：
 * 修改 withdraw 方法以返回一个布尔值，指示交易是否成功。
 * 实验目的： ：
 * 使用有返回值的方法。
 * 
 * 输出结果：
 * Creating the customer Jane Smith.
 * Creating her account with a 500.00 balance.
 * Withdraw 150.00: true
 * Deposit 22.50: true
 * Withdraw 47.62: true
 * Withdraw 400.00: false
 * Customer [Smith, Jane] has a balance of 324.88
 */
public class TestBanking3 {

			  public static void main(String[] args) {
			    Customer customer;
			    Account  account;
			
			    // Create an account that can has a 500.00 balance.
			    System.out.println("Creating the customer Jane Smith.");
				//code 
			    customer  = new Customer("Jans", "Smith");
			    
			    System.out.println("Creating her account with a 500.00 balance.");
				//code
			    customer.setAccount(new Account(500.00));
			  //把 Jane Smith 的账户赋给 customer 变量
			    account = customer.getAccount();
			    
			    // Perform some account transactions
			    System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
			    System.out.println("Deposit 22.50: " + account.deposit(22.50));
			    System.out.println("Withdraw 47.62: " + account.withdraw(47.62));
			    System.out.println("Withdraw 400.00: " + account.withdraw(400.00));
			
			    // Print out the final account balance
			    System.out.println("Customer [" + customer.getLastName()
					       + ", " + customer.getFirstName()
					       + "] has a balance of " + account.getBalance());
			  }
}
