package com.imooc.java;
/**
 * 客车
 * @author LH
 *
 */
public class PassengerCar extends Car {

	//carName 车名 
	//busload 载客量
	//cargo 载货量 
	//rentdaily 日租金	
	
	public PassengerCar() {}

	public PassengerCar(String carName, int busload, double rentdaily) {
		this.carName = carName;
		this.busload = busload;
		this.rentdaily = rentdaily;
	}

	
	    

}