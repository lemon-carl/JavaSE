package com.hr.javase.bank7;

/**
 * 
 * @Name  : CheckingAccount
 * @Author : LH
 * @Date : 2018年7月14日 下午6:16:44
 * @Version : V1.0
 * @Description :
 * 
 * 实现 CheckingAccount 类
 * 1． CheckingAccount 类必须扩展 Account 类
 * 2． 该类必须包含一个类型为 double 的 overdraftProtection 属性。
 * 3． 该类必须包含一个带有参数（balance）的共有构造器。
 * 		 该构造器必须通过调用 super(balance)将 balance 参数传递给父类构造器。
 * 4． 给类必须包括另一个带有两个参数（balance 和 protect）的公有构造器。
 *       该构造器必须通过调用 super(balance)并设置 overdragtProtection 属性，将 balance 参数传递给父类构造器。
 * 5．CheckingAccount 类必须覆盖 withdraw 方法。此方法必须执行下列检查。如 果当前余额足够弥补取款 amount,则正常进行。
 * 		 如果不够弥补但是存在透支 保护，则尝试用 overdraftProtection 得值来弥补该差值（balance-amount）. 
 *		 如果弥补该透支所需要的金额大于当前的保护级别。则整个交易失败，但余 额未受影响。
 */
public class CheckingAccount extends Account {
			
	        //表示透支保护
			private double overdraftProtection;

			
			public CheckingAccount(double init_balance) {
				super(init_balance);
			}

			public CheckingAccount(double init_balance, double overdraftProtection) {
				super(init_balance);
				this.overdraftProtection = overdraftProtection;
			}
			
			/**
			 * * 重写 withdraw 方法； 
			 * 此方法必须执行下列检查。如果当前余额足够弥补取款amount,则正常进行。
			 * 如果不够弥补但是存在透支保护，则尝试用overdraftProtection得值来弥补该差值（balance-amount）.
			 * 如果弥补该透支所需要的金额大于当前的保护级别。则整个交易失败，但余额未受影响。
			 * 
			 * 修改 CheckingAccount 类
			 * 6． 重写 withdraw 方法使它不返回值（即 void）
			 * 7． 修改代码使其在需要时抛出异常。两种情况要处理：
			 * 第一是存在没有透支保护的赤字，对这个异常使用“no overdraft protection”信息。
			 * 第二是 overdraftProtection 数额不足以弥补赤字：对这个异常可使用 ”Insufficient funds for overdraft protection”信息
			 * 
			 */
			@Override
			public void withdraw(double amt) {
					if(balance >= amt) {
						balance -=amt;
					}else {
						
						if(overdraftProtection == -1) {
							 throw new OverdraftException("no overdraft protection",  amt - balance);
						}
						
						//透支保护足够
						if(overdraftProtection >=(amt - balance)) {
							overdraftProtection -= (amt - balance);
							balance =0;
						}else {  //余额不足，透支保护也不足
							//return false;
							throw new OverdraftException("Insufficient funds for overdraft protection", amt - balance);
						}
					}
						
					//return true;
				
			}
			
			

}
