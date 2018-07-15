package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

import java.text.NumberFormat;

import com.hr.javase.bank5_2.Account;
import com.hr.javase.bank5_2.Bank;
import com.hr.javase.bank5_2.CheckingAccount;
import com.hr.javase.bank5_2.Customer;
import com.hr.javase.bank5_2.SavingAccount;

/**
 * 
 * @Name  : TestBanking5_2
 * @Author : LH
 * @Date : 2018年7月14日 下午7:18:40
 * @Version : V1.0
 * 
 * @Description :
 * 2．  完成 TestBanking 程序：该程序创建一个客户和账户的集合，并生成这些客户及其账户余额的报告。
 * 在 TestBanking。Java 文件中，你会发现注释块以来开头和结尾。这些注释只是必须提供的代码的位置。
 * 3．  使用 instanceof 操作符测试拥有的账户类型，并且将 account_type 设置为适当的值，
 * 例如：“Savings Account”或“Checking Account” 。
 * 4．  编译并运行该程序，将看到下列结果
 * CUSTOMERS REPORT
 * ================
 * Customer: Simms, Jane
 * Savings Account: current balance is ￥500.00
 * Checking Account: current balance is ￥200.00
 * Customer: Bryant, Owen
 * Checking Account: current balance is ￥200.00
 * Customer: Soley, Tim
 * Savings Account: current balance is ￥1,500.00
 * Checking Account: current balance is ￥200.00
 * Customer: Soley, Maria
 * Checking Account: current balance is ￥200.00
 * Savings Account: current balance is ￥150.00
 */
public class TestBanking5_2 {

			  public static void main(String[] args) {
			    NumberFormat currency_format = NumberFormat.getCurrencyInstance();
			    Bank   bank = new Bank();
			    Customer customer;
			
			    // Create several customers and their accounts
			    bank.addCustomer("Jane", "Simms");
			    customer = bank.getCustomer(0);
			    customer.addAccount(new SavingAccount(500.00, 0.05));
			    customer.addAccount(new CheckingAccount(200.00, 400.00));
			
			    bank.addCustomer("Owen", "Bryant");
			    customer = bank.getCustomer(1);
			    customer.addAccount(new CheckingAccount(200.00));
			
			    bank.addCustomer("Tim", "Soley");
			    customer = bank.getCustomer(2);
			    customer.addAccount(new SavingAccount(1500.00, 0.05));
			    customer.addAccount(new CheckingAccount(200.00));
			
			    bank.addCustomer("Maria", "Soley");
			    customer = bank.getCustomer(3);
			    // Maria and Tim have a shared checking account
			    customer.addAccount(bank.getCustomer(2).getAccount(1));
			    customer.addAccount(new SavingAccount(150.00, 0.05));
			
			    // Generate a report
			    System.out.println("\t\t\tCUSTOMERS REPORT");
			    System.out.println("\t\t\t================");
			
			    for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++ ) {
			      customer = bank.getCustomer(cust_idx);
			
			      System.out.println();
			      System.out.println("Customer: "
						 + customer.getFirstName() + ", "
						 + customer.getLastName());
			
			      for ( int acct_idx = 0; acct_idx < customer.getNumberOfAccounts(); acct_idx++ ) {
				Account account = customer.getAccount(acct_idx);
				String  account_type = "";
			
				// Determine the account type
				/*** Step 1:
				**** Use the instanceof operator to test what type of account
				**** we have and set account_type to an appropriate value, such
				**** as "Savings Account" or "Checking Account".
				***/
				if(account instanceof SavingAccount) {
					account_type="Savings Account";
				}else if(account instanceof CheckingAccount) {
					account_type="Checking Account";
				}
			
				// Print the current balance of the account
				/*** Step 2:
				**** Print out the type of account and the balance.
				**** Feel free to use the currency_format formatter
				**** to generate a "currency string" for the balance.
				***/
				System.out.println(account_type +": current balance is ￥" +account.getBalance());
				
			      }
			    }
			  }
}
