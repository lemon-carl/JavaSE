package com.hr.javase.bank;

/**
 * 
 * @Name  : Account
 * @Author : LH
 * @Date : 2018年7月2日 下午10:44:46
 * @Version : V1.0
 * 
 * @Description :
 * 提示： ：
 * 1．创建 banking 包
 * 2． 在 banking 包下创建 Account 类。该类必须实现上述 UML 框图中的模型。
 *    a. 声明一个私有对象属性：balance，这个属性保留了银行帐户的当前（或 即时）余额。
 *    b. 声明一个带有一个参数（init_balance）的公有构造器，这个参数为balance 属性赋值。
 *    c. 声明一个公有方法 geBalance，该方法用于获取经常余额。
 *    d. 声明一个公有方法 deposit,该方法向当前余额增加金额。
 *    e. 声明一个公有方法 withdraw 从当前余额中减去金额。
 */
public class Account {

		
		private double balance;
		
		public Account(double  init_balance) {
			this.balance = init_balance;
		}
		
		/**
		 * 
		 * @return 返回余额
		 */
		public double getBalance() {
			return balance;
		}
		
		/**
		 * 存钱方法
		 * @param amt 存款的钱数
		 */
		public void deposit(double amt) {
			  this.balance += amt;
		}
		
		/**
		 * 取钱方法
		 * @param amt 取款的钱数
		 */
		public void withdraw(double amt) {
			this.balance -= amt;
		}
		

}
