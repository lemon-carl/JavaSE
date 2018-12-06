package com.hr.array;

/**
 * 快速排序
 * @author LH
 *
 */
public class QuickSort {

	public static void quickSort(String [] strDate, int left, int right){
		String middle,tempDate;
		int i, j;
			i = left;
			j = right;
		   middle = strDate[(i+j)/2];
	   
	   do {
			    while(strDate[i].compareTo(middle) < 0 && i< right){
			    		i++; //找出左边比中间值大的数
			    }
			    
			    while (strDate[j].compareTo(middle) > 0 && j > left) {
			    		j--;//找出右边比中间值小的数				
				}
			    //将左边大的数和右边小的数进行替换
			    if(i <= j){
			    	tempDate = strDate[i];
			    	strDate[i] = strDate[j];
			    	strDate[j] = tempDate;
			    	i++;
			    	j--;
			    }
			    
	   } while (i <= j); //当两者交错时停止
	   
	   if(i < right){
		   quickSort(strDate, i, right);
	   }
	   if(j > left){
		   quickSort(strDate, left, j);
	   }
	   
	}
	
	
	
	
}
