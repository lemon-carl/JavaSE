package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

import com.hr.javase.bank6.Bank;
import com.hr.javase.bank6.CheckingAccount;
import com.hr.javase.bank6.Customer;
import com.hr.javase.bank6.CustomerReport;
import com.hr.javase.bank6.SavingAccount;

/**
 * 
 * @Name  : TestBanking6
 * @Author : LH
 * @Date : 2018年7月16日 上午12:15:02
 * @Version : V1.0
 * 
 * @Description : 实验题目 6： ： ( 在5_ 续1 的基础上修改)
 * 修改 Bank 类来实现单例设计模式：
 * 实验目的： ：
 * 单例模式。
 */
public class TestBanking6 {

				  public static void main(String[] args) {
				    Bank   bank = Bank.getBanking();
				   // Bank bank = new Bank();
					  Customer customer;
				    CustomerReport report = new CustomerReport();
				
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
				    report.generateReport();
				  }
}
