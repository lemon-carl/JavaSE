package com.lh.variable;

public class smallT {

	public static void main(String[] args) {
        smallT t = new smallT();
        int b =t.get();
        System.out.println(b); //2
	}
    
	public int get(){
		try{
			return 1;
		}finally{
			return 2;
		}
	}
}
