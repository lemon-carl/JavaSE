package com.hr.javase.bank5;

/**
 * 
 * @Name  : Customer
 * @Author : LH
 * @Date : 2018年7月14日 下午5:34:36
 * @Version : V1.0
 * 
 * @Description :
 */
public class Customer {

	
		private  String firstName;
		private String lastName;
		//代表用户有的账户属性
		private Account account;
	
		public Customer(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		
	
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
		
		

}
