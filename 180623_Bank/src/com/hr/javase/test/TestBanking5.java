package com.hr.javase.test;
/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import com.hr.javase.bank5.Account;
import com.hr.javase.bank5.Bank;
import com.hr.javase.bank5.CheckingAccount;
import com.hr.javase.bank5.Customer;
import com.hr.javase.bank5.SavingAccount;

/**
 * 
 * @Name  : TestBanking5
 * @Author : LH
 * @Date : 2018年7月14日 下午6:11:00
 * @Version : V1.0
 * 
 * @Description :
 * 实验题目 5： ：
 * 在银行项目中创建 Account 的两个子类：SavingAccount 和 CheckingAccount
 * 实验目的： ：
 * 继承、多态、方法的重写。
 *
 *  6． 在主 exercise1 目录中，编译并执行 TestBanking 程序。输出应为：
 *    Creating the customer Jane Smith.
 *    Creating her Savings Account with a 500.00 balance and 3% interest.
 *    Creating the customer Owen Bryant.
 *    Creating his Checking Account with a 500.00 balance and no
 *    overdraft protection.
 *    Creating the customer Tim Soley.
 *    Creating his Checking Account with a 500.00 balance and 500.00 in
 *    overdraft protection.
 *    Creating the customer Maria Soley.
 *    Maria shares her Checking Account with her husband Tim.
 *    Retrieving the customer Jane Smith with her savings account.
 *    Withdraw 150.00: true
 *    Deposit 22.50: true
 *    Withdraw 47.62: true
 *    Withdraw 400.00: false
 *    Customer [Simms, Jane] has a balance of 324.88
 *    Retrieving the customer Owen Bryant with his checking account with
 *    no overdraft protection.
 *    Withdraw 150.00: true
 *    Deposit 22.50: true
 *    Withdraw 47.62: true
 *    Withdraw 400.00: false
 *    Customer [Bryant, Owen] has a balance of 324.88
 *    Retrieving the customer Tim Soley with his checking account that
 *    has overdraft protection.
 *    Withdraw 150.00: true
 *    Deposit 22.50: true
 *    Withdraw 47.62: true
 *    Withdraw 400.00: true
 *    Customer [Soley, Tim] has a balance of 0.0
 *    Retrieving the customer Maria Soley with her joint checking account
 *    with husband Tim.
 *    Deposit 150.00: true
 *    Withdraw 750.00: false
 *    Customer [Soley, Maria] has a balance of 150.0
 */
public class TestBanking5 {

					  public static void main(String[] args) {
					    Bank     bank = new Bank();
					    Customer customer;
					    Account account;
					
					    //
					    // Create bank customers and their accounts
					    //
					
					    System.out.println("Creating the customer Jane Smith.");
					    bank.addCustomer("Jane", "Simms");
					    //code
					    System.out.println("Creating her Savings Account with a 500.00 balance and 3% interest.");
					    //code
					    bank.getCustomer(0).setAccount(new SavingAccount(500.00, 0.03));
					    
					    System.out.println("Creating the customer Owen Bryant.");
					    //code
					    bank.addCustomer("Owen", "Bryant");
					    customer = bank.getCustomer(1);
					    System.out.println("Creating his Checking Account with a 500.00 balance and no overdraft protection.");
					    //code
					    customer.setAccount(new CheckingAccount(500.00));
					    
					    System.out.println("Creating the customer Tim Soley.");
					    bank.addCustomer("Tim", "Soley");
					    customer = bank.getCustomer(2);
					    
					    System.out.println("Creating his Checking Account with a 500.00 balance and 500.00 in overdraft protection.");
					    //code
					    customer.setAccount(new CheckingAccount(500.00,500.00));
					    
					    System.out.println("Creating the customer Maria Soley.");
					    //code
					    bank.addCustomer("Maria", "Soley");
					    customer = bank.getCustomer(3);
					    System.out.println("Maria shares her Checking Account with her husband Tim.");
					    customer.setAccount(bank.getCustomer(2).getAccount());
					
					    System.out.println();
					
					    //
					    // Demonstrate behavior of various account types
					    //
					
					    // Test a standard Savings Account
					    System.out.println("Retrieving the customer Jane Smith with her savings account.");
					    customer = bank.getCustomer(0);
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
					
					    System.out.println();
					
					    // Test a Checking Account w/o overdraft protection
					    System.out.println("Retrieving the customer Owen Bryant with his checking account with no overdraft protection.");
					    customer = bank.getCustomer(1);
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
					
					    System.out.println();
					
					    // Test a Checking Account with overdraft protection
					    System.out.println("Retrieving the customer Tim Soley with his checking account that has overdraft protection.");
					    customer = bank.getCustomer(2);
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
					
					    System.out.println();
					
					    // Test a Checking Account with overdraft protection
					    System.out.println("Retrieving the customer Maria Soley with her joint checking account with husband Tim.");
					    customer = bank.getCustomer(3);
					    account = customer.getAccount();
					    // Perform some account transactions
					    System.out.println("Deposit 150.00: " + account.deposit(150.00));
					    System.out.println("Withdraw 750.00: " + account.withdraw(750.00));
					    // Print out the final account balance
					    System.out.println("Customer [" + customer.getLastName()
							       + ", " + customer.getFirstName()
							       + "] has a balance of " + account.getBalance());
					
					  }
}
