package com.hr.javase.bank8;

import java.util.Iterator;

/**
 * 
 * @Name  : CustomerReport
 * @Author : LH
 * @Date : 2018年7月18日 下午11:29:26
 * @Version : V1.0
 * 
 * @Description :
 * 
 * 可选：修改 CustomerReport 类
 * 修改 CustomerReport 类，使用 Iterator 实现对客户的迭代
 * 1． 在 Bank 类中，添加一个名为 getCustomers 的方法，该方法返回一个客户列 表上的 iterator
 * 2． 在 Customer 类中，添加一个名为个体 Accounts 的方法，该方法返回一个帐 户列表上的 iterator
 * 3． 修改 CustomerReport 类，使用一对嵌套的 while 循环（而不是使用嵌套的for 循环），在客户的 iterator 与帐户的 iterator 上进行迭代
 * 4． 重新编译运行 TestBanking 程序，应看到与上面一样的输出结果
 */
public class CustomerReport {

				public void generateReport() {
					
						Bank bank = Bank.getBanking();
					   Customer customer = null;
					
					// Generate a report
				    System.out.println("\t\t\tCUSTOMERS REPORT");
				    System.out.println("\t\t\t================");
				
				    Iterator<Customer> cIterator = bank.getCustomers();
				  //  for ( int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++ ) {
				  //    customer = bank.getCustomer(cust_idx);
				while (cIterator.hasNext()) {
					 customer =  cIterator.next();
					
				      System.out.println();
				      System.out.println("Customer: "
							 + customer.getFirstName() + ", "
							 + customer.getLastName());
				
				     // for ( int acct_idx = 0; acct_idx < customer.getNumberOfAccounts(); acct_idx++ ) {
					//Account account = customer.getAccount(acct_idx);
				      Iterator<Account> aIterator = customer.getAccounts();
				      
				      while (aIterator.hasNext()) {
				    	  Account account = aIterator.next();
						
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
