package com.ann.test;

import com.ann.bean.Child;
import com.ann.bean.Person;

/**
 * 
 * @Name  : Test1
 * @Author : LH
 * @Date : 2018年6月9日 上午10:54:30
 * @Version : V1.0
 * 
 * @Description : Java 中常见注解
 *     JDK自带注解：
 *          @Override  ：重写（覆盖）父类中的方法
 *          @Deprecated  ：设置方法过时
 *          @SuppressWarnings("deprecation" ) ：忽略deprecation这个警告
 *     第三方注解：
 *         Spring ：
 *            		@Controller,@Autowird,@Service,@Repository,   
 *          Mybatis:
 *                  @InsertProvider,UpdateProvider,@Options
 *          
 */
public class Test1 {
      
	  //忽略deprecation这个“方法过时”的警告
	  @SuppressWarnings("deprecation" )
	   public void sing() {
		   Person person = new Child();
		   person.sing();
	   }
}
