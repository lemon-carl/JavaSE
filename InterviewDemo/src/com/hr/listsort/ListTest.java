package com.hr.listsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * list集合排序先后顺序：1-9，A-Z,a-z
 *@Description:
 *@Name : ListTest
 *@Author : LH
 *@Date : 2018-6-1下午11:52:46
 *@Version : V1.0
 *
 */
public class ListTest {

	
	@SuppressWarnings("unchecked")
	@Test
	public void testSort(){
		
		
		List list = new ArrayList();
		list.add("1");
		list.add("a");
		list.add("2");
		list.add("d");
		list.add("b");
		list.add("5");
		list.add("3");
		
		Collections.sort(list);
		
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
