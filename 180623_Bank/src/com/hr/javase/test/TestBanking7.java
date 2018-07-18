package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a set of customers, with a few accounts each,
 * and generates a report of current account balances.
 */

import com.hr.javase.bank7.Account;
import com.hr.javase.bank7.Bank;
import com.hr.javase.bank7.CheckingAccount;
import com.hr.javase.bank7.Customer;
import com.hr.javase.bank7.OverdraftException;
import com.hr.javase.bank7.SavingAccount;

/**
 * 
 * @Name  : TestBanking7
 * @Author : LH
 * @Date : 2018年7月18日 下午10:53:38
 * @Version : V1.0
 * 
 * @Description : 实验题目 7：（在 6 基础上修改）
 * 将建立一个 OverdraftException 异常，它由 Account 类的 withdraw()方法抛出。
 * 
 * 
 * 编译并运行 TestBanking 程序
 * Customer [simms,Jane]has a checking balance of 200.0 with a 500.0 overdragt
 * protection
 * Checking Acct[Jane Simms]: withdraw 150.00
 * Checking Acct[Jane Simms]: deposit 22.50
 * Checking Acct[Jane Simms]: withdraw 147.62
 * Checking Acct[Jane Simms]: withdraw 470.00
 * Exception: Insufficient funds for overdraft protection
 * Deifcit:470.0
 * Customer [Simms,Jane]has a checking balance of 0.0
 * Customer [Bryant,Owen]has a checking balance of 200.0
 * Checking Acct[Bryant,Owen]: withdraw 100.00
 * Checking Acct[Bryant,Owen]: deposit25.00
 * Checking Acct[Bryant,Owen]: withdraw 175.00
 * Exception: no overdraft protection Deficit:50.0
 * Customer [Bryant,Owen]has a checking balance of 125.0
 */
public class TestBanking7 {

				  public static void main(String[] args) {
				    Bank     bank = Bank.getBanking();
				    Customer customer;
				    Account  account;
				
				    // Create two customers and their accounts
				    bank.addCustomer("Jane", "Simms");
				    customer = bank.getCustomer(0);
				    customer.addAccount(new SavingAccount(500.00, 0.05));
				    customer.addAccount(new CheckingAccount(200.00, 500.00));
				    bank.addCustomer("Owen", "Bryant");
				    customer = bank.getCustomer(1);
				    customer.addAccount(new CheckingAccount(200.00));
				
				    // Test the checking account of Jane Simms (with overdraft protection)
				    customer = bank.getCustomer(0);
				    account = customer.getAccount(1);
				    System.out.println("Customer [" + customer.getLastName()
						       + ", " + customer.getFirstName() + "]"
						       + " has a checking balance of "
						       + account.getBalance()
							 + " with a 500.00 overdraft protection.");
				    try {
				      System.out.println("Checking Acct [Jane Simms] : withdraw 150.00");
				      account.withdraw(150.00);
				      System.out.println("Checking Acct [Jane Simms] : deposit 22.50");
				      account.deposit(22.50);
				      System.out.println("Checking Acct [Jane Simms] : withdraw 147.62");
				      account.withdraw(147.62);
				      System.out.println("Checking Acct [Jane Simms] : withdraw 470.00");
				      account.withdraw(470.00);
				    } catch (OverdraftException e1) {
				      System.out.println("Exception: " + e1.getMessage()
							 + "   Deficit: " + e1.getDeficit());
				    } finally {
				      System.out.println("Customer [" + customer.getLastName()
							 + ", " + customer.getFirstName() + "]"
							 + " has a checking balance of "
							 + account.getBalance());
				    }
				    System.out.println();
				
				    // Test the checking account of Owen Bryant (without overdraft protection)
				    customer = bank.getCustomer(1);
				    account = customer.getAccount(0);
				    System.out.println("Customer [" + customer.getLastName()
						       + ", " + customer.getFirstName() + "]"
						       + " has a checking balance of "
						       + account.getBalance());
				    try {
				      System.out.println("Checking Acct [Owen Bryant] : withdraw 100.00");
				      account.withdraw(100.00);
				      System.out.println("Checking Acct [Owen Bryant] : deposit 25.00");
				      account.deposit(25.00);
				      System.out.println("Checking Acct [Owen Bryant] : withdraw 175.00");
				      account.withdraw(175.00);
				    } catch (OverdraftException e1) {
				      System.out.println("Exception: " + e1.getMessage()
							 + "   Deficit: " + e1.getDeficit());
				    } finally {
				      System.out.println("Customer [" + customer.getLastName()
							 + ", " + customer.getFirstName() + "]"
							 + " has a checking balance of "
							 + account.getBalance());
				    }
				  }
}
