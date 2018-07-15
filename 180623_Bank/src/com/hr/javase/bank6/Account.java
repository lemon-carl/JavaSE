package com.hr.javase.bank6;

/**
 * 
 * @Name  : Account
 * @Author : LH
 * @Date : 2018年7月14日 下午7:17:04
 * @Version : V1.0
 * 
 * @Description :
 */
public class Account {

		
		protected double balance;
		
		public Account(double  init_balance) {
			this.balance = init_balance;
		}
		
		/**
		 * @return 返回余额
		 */
		public double getBalance() {
			return balance;
		}
		
		/**
		 * 存钱方法
		 * @param amt 存款的钱数
		 * @return  返回存款是否成功
		 */
		public boolean deposit(double amt) {
			  this.balance += amt;
			  return true;
		}
		
		/**
		 * 取钱方法
		 * @param amt 取款的钱数
		 * @return 返回取款是否成功
		 */
		public boolean  withdraw(double amt) {
			//检查提款数目是否大于余额
			if( amt > balance ) {
				return false;
			}
			
			this.balance -= amt;
			return  true;
			
		}
		

}
