package com.hr.javase.test;

import com.hr.javase.bank8.Bank;
import com.hr.javase.bank8.CheckingAccount;
import com.hr.javase.bank8.Customer;
import com.hr.javase.bank8.CustomerReport;
import com.hr.javase.bank8.SavingAccount;

/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

/**
 * 
 * @Name  : TestBanking8
 * @Author : LH
 * @Date : 2018年7月18日 下午11:24:03
 * @Version : V1.0
 * 
 * @Description :实验题目 8： ：
 * 		将替换这样的数组代码：这些数组代码用于实现银行和客户间，以及客户与他们的帐户间的关系的多样性。
 * 实验目的： ：
 * 		使用集合
 * 
 * 编译运行 TestBanking 程序这里，不必修改 CustomerReport 代码，因为并没有改变 Bank 和Customer 类的接口。
 * 编译运行TestBanking应看到下列输出结果：
 * CUSTOMERS REPORT
 * ==================
 * Customer：Simms,Jane
 * Savings Account:current balance is $500.00 
 * Checking Account:current balance is $200.00
 * Customer:Bryant,Owen
 * Checking Accout:current balance is $200
 * Customer:Soley,Tim
 * Savings Account:current balance is $1,500.00
 * Checking Account:current balance is $200.00
 * Customer:Soley,Tim
 * Checking Account:current balance is $200.00
 * Savings Account :current balance is $150.00
 */
public class TestBanking8 {

				  public static void main(String[] args) {
				    Bank     bank = Bank.getBanking();
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
