package com.imooc.java;
/**
 * 货车
 * @author LH
 *
 */
public class Trunk extends Car {

	//carName 车名 
	//busload 载客量
	//cargo 载货量 
	//rentdaily 日租金	
	
	public Trunk() {}
	
	public Trunk(String carName,  double cargo, double rentdaily) {
		this.carName = carName;
		this.cargo = cargo;
		this.rentdaily = rentdaily;
	}


	

	
	
}
