package com.hr.javase.bank3;

/**
 * 
 * @Name  : Customer
 * @Author : LH
 * @Date : 2018年7月2日 下午11:17:14
 * @Version : V1.0
 * 
 * @Description :
 * 
 * 提  示： ：
 * 1. 在banking包下的创建Customer类。该类必须实现上面的UML图表中的模型。
 * a. 声明三个私有对象属性：firstName、lastName 和 account。
 * b. 声明一个公有构造器，这个构造器带有两个代表对象属性的参数（f 和 l）
 * c. 声明两个公有存取器来访问该对象属性，方法 getFirstName 和 getLastName返回相应的属性。 
 * d. 声明 setAccount 方法来对 account 属性赋值。
 * e. 声明 getAccount 方法以获取 account 属性。
 * 
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
