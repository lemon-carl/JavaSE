package com.hr.demo;

public class HelloWorld {

	public static void main(String [] args){
		/*int num = 999;
		int count = 0;
		
		if(num >0 && num <= 999999999){
			for(count =1;(num/10)>0 ;count ++){
				System.out.println("它是个"+count+"位的数！");
			}
		}*/
		
		 int [] a= {23,12,56,3,18,45,4,-1,-7};
		 
		 for (int i = 0; i < a.length; i++) {
			     System.out.print(a[i] +"\t");
			    for (int j = 0; j < a.length-1; j++) {
					  if(a[j] > a[j+1]){
						   int temp = a[j+1];
						    a[j+1] = a[j];
						    a[j] =temp;
					  }
				}
		}
		 System.out.println("");
		 System.out.println("=====排序后========");
		  for (int i = 0; i < a.length; i++) {
			  System.out.print(a[i] + "\t");
		}
	}
	
	
}
