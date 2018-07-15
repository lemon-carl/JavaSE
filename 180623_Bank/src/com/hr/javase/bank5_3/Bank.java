package com.hr.javase.bank5_3;

/**
 * 
 * @Name  : Bank
 * @Author : LH
 * @Date : 2018年7月14日 下午5:16:52
 * @Version : V1.0
 * 
 * @Description : 代表银行对象
 * 
 * a. 创建 Bank 类
 * b. 为 Bank 类 增 加 两 个 属 性 ： customers(Customer对象的数组 ) 和 numberOfCustomers(整数，跟踪下一个 customers 数组索引)
 * c. 添加公有构造器，以合适的最大尺寸（至少大于 5）初始化 customers 数组。
 * d. 添加 addCustomer 方法。该方法必须依照参数（姓，名）构造一个新的
 * Customer对象然后把它放到 customer 数组中。还必须把 numberOfCustomers属性的值加 1。
 * e. 添加 getNumOfCustomers 访问方法，它返回 numberofCustomers 属性值。
 * f. 添加 getCustomer方法。它返回与给出的index参数相关的客户。
 */
public class Bank {
	
			//当前 Bank 中有多个 Cutomer
			private Customer [] customers;
			//表示 customers 变量中有多少个真正的 Customer 对象
			private int numberOfCustomers;
			
			public Bank() {
					customers = new Customer[5];
			}
			
			/**
			 *  根据传入的参数创建一个新的 Cusotmer 对象, 并把该对象赋给 customers 中指定的元素
			 * @param firstName
			 * @param lastName
			 */
			public void addCustomer(String firstName, String lastName) {
					//1.根据传入的参数创建一个新的 Cusotmer 对象
					Customer customer = new Customer(firstName, lastName);
					//2.把 1 新创建的 Customer 对象赋给 customers 中指定的元素
					customers[numberOfCustomers] = customer;
					//3. 使表示 customers 变量中有多少个真正的 Customer 对象的整数 + 1
					numberOfCustomers++;
			
			}
			
			/**
			 *  返回 表示 customers 变量中有多少个真正的 Customer 对象的整数
			 * @return
			 */
			public int getNumOfCustomers() {
				return numberOfCustomers;
			}
			
			/**
			 * 返回指定索引对应的 Customer 对象
			 * @param index
			 * @return
			 */
			public Customer getCustomer(int index) {
					return customers[index];
			}
	
	
}
