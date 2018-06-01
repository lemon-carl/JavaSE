package com.hr.test2;
/**
 * 
 *@Name : Human
 *@Author : LH
 *@Date : 2018-3-15ÏÂÎç05:54:23
 *@Version : V1.0
 * @Description:
 */
public class Human {

	
	public static void main(String[] args)throws Exception {
		
		
		/*try {
			    throw new Sneeze();
		}catch(Sneeze s){
				System.out.println("Caught Sneeze");
		} catch (Annoyance a) {
               System.out.println("Caught Annoyance");
		}	
		try{	
			 throw new Sneeze();
		}catch(Annoyance a){
			System.out.println("Caught Annoyance");
		}finally{
			System.out.println("Hello World!");
		}*/
		try{	
			try {
				    throw new Sneeze();
			} catch (Annoyance a) {
	               System.out.println("Caught Annoyance");
	               throw a;
			}	
	
		}catch(Sneeze s){
			System.out.println("Caught Sneeze");
			return ;
		}finally{
			System.out.println("Hello World!");
		}
	}
}
