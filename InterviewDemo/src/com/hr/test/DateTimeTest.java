package com.hr.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * 
 *@Name : DateTimeTest
 *@Author : LH
 *@Date : 2018-3-15下午03:29:51
 *@Version : V1.0
 * @Description:
 * 1、jdk1.7获取年月日、小时分钟秒
 * 2、1.7获取1970年1月1日0时0分0秒到现在的毫秒数
 * 3、获取某月的最后一天
 * 4、格式化日期
 * 5、昨天的当前时刻
 */
public class DateTimeTest {

	
	@Test
	public void myTest(){
		//1\jdk1.7获取年月日、小时分钟秒
		Calendar cal =Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"\t");//年
		System.out.print(cal.get(Calendar.MONTH)+1+"\t");//月
		System.out.print(cal.get(Calendar.DATE)+"\t");//日
		System.out.print(cal.get(Calendar.HOUR_OF_DAY)+"\t");//时
		System.out.print(cal.get(Calendar.MINUTE)+"\t");//分
		System.out.println(cal.get(Calendar.SECOND)+"\t");//秒

		//2、1.7获取1970年1月1日0时0分0秒到现在的毫秒数
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(System.currentTimeMillis());
		
		//3、获取某月的最后一天
		Calendar time = Calendar.getInstance();
		int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		//4、格式化日期
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
	    System.out.println(oldFormatter.format(date));
	    
	    //5、昨天的当前时刻
	    Calendar cal2 = Calendar.getInstance();
	    cal2.add(Calendar.DATE, -1);
	    System.out.println(cal2.getTime());
	    System.out.println(oldFormatter.format(cal2.getTime()));
	}
}
