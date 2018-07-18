package com.hr.javase.bank8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @Name  : Customer
 * @Author : LH
 * @Date : 2018年7月14日 下午7:17:26
 * @Version : V1.0
 * 
 * @Description :
 * 修改 Customer 类
 * 1．  修改 Customer 类来处理具有多种类型的联合账户。
 * （例如用数组表示多重 性 一 节 所 作 的 ， 该 类 必 须 包 括 以 下 的 公 有 方 法 ：
 * 	addAccount(Account),getAccount(int)和 getNumOfAccount）
 * 
 * 修改 Customer 类
 * 6． 修改 Customer 类，使用 ArrayList 实现多重的账户关系。修改方法同上。
 * 
 */
public class Customer {

	
		private  String firstName;
		private String lastName;
		//代表用户有的账户属性
		//private Account [] accounts;
		//private int numberOfAccounts;
		
		List<Account> accounts;
	
		public Customer(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			//accounts = new Account[2];
			accounts = new ArrayList<>();
		}

		
	
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}

		public void addAccount(Account account) {
			//accounts[numberOfAccounts++] =account;
	
			accounts.add(account);
		}

		public Account getAccount(int index) {
			//return accounts[index];
			return accounts.get(index);
		}

		public int getNumberOfAccounts() {
			//return numberOfAccounts;
			return accounts.size();
		}
		
		public Iterator<Account> getAccounts(){
				return accounts.iterator();
		}
		

}
