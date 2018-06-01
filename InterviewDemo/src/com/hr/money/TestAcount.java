package com.hr.money;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 *@Name : TestAcount
 *@Author : LH
 *@Date : 2018-3-22上午11:59:27
 *@Version : V1.0
 * @Description:  测试100个账户同时向一个银行账户存入1元钱，在没有使用同步机制和使用同步机制的情况下的执行情况
 */
public class TestAcount {

	
	public static void main(String[] args) {
		
		Account account = new Account();
	    /**
	     * 创建一个线程池，该线程池重用使用共享无界队列运行的固定数量的线程。 
	     * 在任何时候，最多nThreads线程都将被激活处理任务。
	     * 如果在所有线程处于活动状态时提交其他任务，则它们将在队列中等待，直到线程可用。
	     * 如果任何线程在关闭之前的执行期间由于失败而终止，则在需要执行后续任务时将取代它。
	     * 池中的线程将一直存在，直到它被明确关闭。
	     */
		ExecutorService service =Executors.newFixedThreadPool(100);
		
		for (int i = 1; i <= 100; i++) {
			service.execute(new AddMoneyThread(account, 1));
		}
	    
		service.shutdown();
		
		while(!service.isTerminated()){
			
		}
		
		System.out.println("账户余额：" + account.getBalance());
	
	}
}
