package com.hr.javase.bank8;

/**
 * 
 * @Name  : OverdraftException
 * @Author : LH
 * @Date : 2018年7月18日 下午10:57:18
 * @Version : V1.0
 * 
 * @Description : 创建 OverdraftException 类
 * 1． 在 banking.domain 包中建立一个共有类 OverdraftException. 这个类扩展RuntimeException 类。
 * 2． 添加一个 double 类型的私有属性 deficit.增加一个共有访问方法 getDeficit
 * 3． 添加一个有两个参数的共有构造器。deficit 参数初始化 deficit 属性
 */
public class OverdraftException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double deficit;

	public double getDeficit() {
		return deficit;
	}

	public OverdraftException(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}
	
	
	
	
	
}
