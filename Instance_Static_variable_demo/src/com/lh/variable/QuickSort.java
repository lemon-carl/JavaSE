package com.lh.variable;

/**
 * øÏÀŸ≈≈–Ú
 * @author LH
 *
 */
public class QuickSort {

	public static void main(String[] args) {
                String [] strVoid = new String[]{"11","66","22","0","55","22","0","32"};
              QuickSort sort = new QuickSort();
              System.err.println(System.currentTimeMillis()+"==1==");
              System.out.println(" ");
               sort.quickSort(strVoid, 0, strVoid.length-1);
               for (int i = 0; i < strVoid.length; i++) {
				System.out.print(strVoid[i] + ", ");
			}
               System.err.println(System.currentTimeMillis()+"==2==");
	}

	public void quickSort(String [] strDate, int left, int right){
		String middle,tempDate;
		int i, j;
		i = left;
		j = right;
	   middle = strDate[(i+j)/2];
	   do {
		    while(strDate[i].compareTo(middle) < 0 && i< right){
		    	i++;
		    }
		    while (strDate[j].compareTo(middle) > 0 && j > left) {
                  j--;				
			}
		    if(i <= j){
		    	tempDate = strDate[i];
		    	strDate[i] = strDate[j];
		    	strDate[j] = tempDate;
		    	i++;
		    	j--;
		    }
	   } while (i <= j);
	   
	   if(i < right){
		   quickSort(strDate, i, right);
	   }
	   if(j > left){
		   quickSort(strDate, left, j);
	   }
	}
	
	
	
	
}
