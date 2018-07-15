package com.hr.javase.bank5_3;

/**
 * 
 * @Name  : Customer
 * @Author : LH
 * @Date : 2018年7月15日 下午11:21:46
 * @Version : V1.0
 * @Description :修改客户使其拥有两个账户
 * 修改  Customer  类使其拥有两个银行账户：一个储蓄账户和一个支票账户：两个都是可选的。
 * 11．  原来的 Customer 类包含一个称作 account 的关联属性，可用该属性控制一个 Account 对象。
 * 重写这个类，使其包含两个关联属性：savingsAccount 和 checkingAccount，这两个属性的缺省值是 null
 * 12．  包含两个访问方法：getSavings 和 getChecking，这两个方法分别返回储蓄和支票总数。
 * 13．  包含两个相反的方法：SetSavings 和 setChecking，这两个方法分别为 savings 和 checking account 这两个关联属性赋值。
 */
public class Customer {

	
		private  String firstName;
		private String lastName;
		private SavingAccount savingsAccount;
		private CheckingAccount checkingAccount;
		
		
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

		public SavingAccount getSavingsAccount() {
			return savingsAccount;
		}

		public void setSavingsAccount(SavingAccount savingsAccount) {
			this.savingsAccount = savingsAccount;
		}

		public CheckingAccount getCheckingAccount() {
			return checkingAccount;
		}

		public void setCheckingAccount(CheckingAccount checkingAccount) {
			this.checkingAccount = checkingAccount;
		}

	

		

}
