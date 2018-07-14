package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import com.hr.javase.bank4.Bank;
import com.hr.javase.bank4.Customer;

/**
 * 
 * @Name  : TestBanking4
 * @Author : LH
 * @Date : 2018年7月14日 下午5:14:45
 * @Version : V1.0
 * 
 * @Description :
 * 实验题目 4： ：
 * 将用数组实现银行与客户间的多重关系。
 * 实验目的： ：
 * 在类中使用数组作为模拟集合操作。
 * 提示： ：
 * 对银行来说，可添加 Bank 类。 Bank 对象跟踪自身与其客户间的关系。用
 * Customer 对象的数组实现这个集合化的关系。还要保持一个整数属性来跟踪
 * 银 行当前有多少客户。
 * 
 * g. 编译并运行 TestBanking 程序。可以看到下列输出结果：
 * Customer [1] is Simms,Jane
 * Customer [2] is Bryant,Owen
 * Customer [3] is Soley,Tim
 * Customer [4] is Soley,Maria
 */
public class TestBanking4 {

			  public static void main(String[] args) {
			       Bank   bank = new Bank();
			
			    	// Add Customer Jane, Simms
			 		// code
			 		bank.addCustomer("Jane", "Smms");
			
			 		// Add Customer Owen, Bryant
			 		// code
			 		bank.addCustomer("Owen", "Bryant");
			
			 		// Add Customer Tim, Soley
			 		// code
			 		bank.addCustomer("Tim", "Soley");
			
			 		// Add Customer Maria, Soley
			 		// code
			 		bank.addCustomer("Maria", "Soley");
			    
				    for ( int i = 0; i < bank.getNumOfCustomers(); i++ ) {
				      Customer customer = bank.getCustomer(i);
				
				      System.out.println("Customer [" + (i+1) + "] is "
							 + customer.getLastName()
							 + ", " + customer.getFirstName());
				    }
			  }
}
