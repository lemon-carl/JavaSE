package com.hr.javase.bank5_3;

/**
 * 
 * @Name  : CheckingAccount
 * @Author : LH
 * @Date : 2018年7月15日 下午10:58:26
 * @Version : V1.0
 * @Description :
 *   6． CheckingAccount 类必须扩展 Account 类
 *   7． 作 该类必须包括一个关联属性，称作  protectedBy ，该属性的类型为
 *        SavingsAccount是 ，缺省值必须是  null 。除此之外该类没有其他的数据属性
 *   8． 该类必须包括一个带有参数（balance）的公有构造器，该构造器必须通
 *         过调用 super（balance）将 balance 参数传递到父类构造器
 *   9． 该类必须包括另外一个带有两个参数的（balance 和 protect）的公有构造器。
 *        该构造器必须通过调用 super（balance）将 balance 参数传递给父类构造器。
 *   10 ．CheckingAccount  类必须覆盖  withdraw  方法。
 *        该类必须执行下面的检查：如果当前余额足够弥补取款  amount ，则正常进行。
 *        如果不够弥补但是存在透支保护则尝试用储蓄账户来弥补这个差值（ balance- - amount ）。
 *        如果后一个交易失败，则整个交易一定失败，但余额未受影响。
 */
public class CheckingAccount extends Account {
			
	        //表示透支保护
			private SavingAccount protectedBy;

			
			public CheckingAccount(double init_balance) {
				super(init_balance);
			}

			public CheckingAccount(double init_balance, SavingAccount protectedBy) {
				super(init_balance);
				this.protectedBy = protectedBy;
			}

			/**
			 * * 重写 withdraw 方法； 
			 * 此方法必须执行下列检查。如果当前余额足够弥补取款amount,则正常进行。
			 * 如果不够弥补但是存在透支保护，则尝试用overdraftProtection得值来弥补该差值（balance-amount）.
			 * 如果弥补该透支所需要的金额大于当前的保护级别。则整个交易失败，但余额未受影响。
			 */
			@Override
			public boolean withdraw(double amt) {
					
					//余额足够
					if(balance >= amt) {
						balance -=amt;
					}else {
						//透支保护足够
						if(protectedBy != null && protectedBy.getBalance() >=(amt - balance)) {
							protectedBy.withdraw(amt - balance);
							balance =0;
						}else {//余额不足，透支保护也不足
							return false;
						}
					}
						
					return true;
				
			}
			
			

}
