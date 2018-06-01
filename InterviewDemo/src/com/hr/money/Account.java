package com.hr.money;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.security.auth.login.AccountLockedException;

/**
 * 
 *@Name : Acount
 *@Author : LH
 *@Date : 2018-3-22上午11:51:06
 *@Version : V1.0
 * @Description: 银行账户
 */
public class Account {

	/**
	 * 方法三
	 * 锁机制，为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作
	 */
	//private Lock accountLock = new ReentrantLock();
	
	
	//账户余额
	private double balance;
	
	/**
	 * 方法二：在银行账户的存款（deposit）方法上同步（synchronized）关键字
	 * 
	 */
	/**
	 * 存款
	 * @param money 存入金额
	 */
	public synchronized void deposit(double money){
		//accountLock.lock();
		
		//try{
			double newBalance = balance + money;
			try {
				//模拟此业务需要一段处理时间
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
	//	}finally{
	//		accountLock.unlock();
		//}
	}

	/**
	 * 
	 * @return 获得账户余额
	 */
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
