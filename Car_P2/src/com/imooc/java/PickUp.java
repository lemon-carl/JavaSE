package com.imooc.java;
/**
 * 皮卡车
 * @author LH
 *
 */
public class PickUp extends Car {


	//carName 车名 
	//busload 载客量
	//cargo 载货量 
	//rentdaily 日租金	
	
	public PickUp() {}

	public PickUp(String carName, int busload, double cargo, double rentdaily) {
		this.carName = carName;
		this.busload = busload;
		this.cargo = cargo;
		this.rentdaily = rentdaily;
	}


	
	
	
}
