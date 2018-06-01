package com.hr.money;

/**
 * 
 *@Name : AddMoneyThread
 *@Author : LH
 *@Date : 2018-3-22上午11:56:13
 *@Version : V1.0
 * @Description: 存钱线程
 */
public class AddMoneyThread implements Runnable {

	//存入账户
	private Account account;
	//存入金额
	private double money;
	
	
	public AddMoneyThread(Account account, double money) {
		this.account = account;
		this.money = money;
	}

    /**
     * 方法二:在线程调用存款方法时对银行账户进行同步
     */
	public void run() {
		synchronized(account){
          account.deposit(money);
		}
	}

}
