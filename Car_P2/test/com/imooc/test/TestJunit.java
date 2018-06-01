package com.imooc.test;

import java.util.Scanner;

import org.junit.Test;

import com.imooc.java.Car;
import com.imooc.java.PassengerCar;
import com.imooc.java.PickUp;
import com.imooc.java.Trunk;

/**
 * 测试:租车系统
 * @author LH
 *
 */
public class TestJunit {

	@Test
	public void TestMain(){
		  Car [] carArry={
				     new PassengerCar("奥迪A4", 4, 500),
	                 new PassengerCar("马自达6", 4, 400),
	                 new PickUp("皮卡雪6", 4, 2, 450),
	                 new PassengerCar("金龙", 20, 800),
	                 new Trunk("松花江",4, 4000 ),
	                 new Trunk("依维柯",20,1000)};
			System.out.println("==================欢迎使用布丁租车系统==================");
			System.out.println("您是否要租车：1—是，0—否");
			Scanner scan=new Scanner(System.in);
			int input=scan.nextInt();
			//需要租车
			if(input==1){
			  int totalBusload = 0;            //总的载客量  
			  int totalCargocapacity=0;        //总的载货量  
			  int totalPrice=0;                //总价格  
			  int rentday ;                    //租车天
			
			  System.out.println("您可租车的类型及其价目表如下：");
			  System.out.println("序号\t"+"车名\t"+"租金\t"+"容量");
			  int i=1;
			  for (Car car : carArry) {
				if(car instanceof PassengerCar){
				    System.out.println(""+ i+".\t"+car.carName + "\t" +car.rentdaily +"元\t"+"载人："+car.busload+"人");
				     	i++;
				}
				if(car instanceof PickUp){
					System.out.println(""+ i+".\t"+car.carName + "\t" + car.rentdaily+"元\t"+"载人："+car.busload+"\t载货："+car.cargo+"吨");
						i++;
				}
				if(car instanceof Trunk){
					System.out.println(""+ i+".\t"+car.carName + "\t" +car.rentdaily +"元\t"+"载货："+car.cargo+"吨");
						i++;
				}
				
			}
			
			
			System.out.println("请输入您要租汽车的数量：");
			int inputInt = scan.nextInt();
			for (int j = 0; j < inputInt ; j++) {
					System.out.println("请输入第" + (j+1) + "辆车的序号：");
					int num=scan.nextInt();
			    
					if(carArry[num-1] instanceof PassengerCar){
						totalBusload += carArry[num-1].busload;
						totalPrice +=carArry[num-1].rentdaily;
					}
					
					if(carArry[num-1] instanceof Trunk){
						totalCargocapacity += carArry[num-1].cargo;
						totalPrice +=carArry[num-1].rentdaily;
					}
					
					if(carArry[num-1] instanceof PickUp){
						totalBusload += carArry[num-1].busload;
						totalCargocapacity +=carArry[num -1].cargo;
						totalPrice +=carArry[num-1].rentdaily;
					}
				  
				}
			System.out.println("请输入天数：");
			Scanner input2=new Scanner(System.in);
			rentday=input2.nextInt();
			totalPrice *= rentday;
			
			System.out.println("==========布丁租车===============");
			System.out.println("你的账单如下：");
			System.out.println("**********************");
			System.out.println("总载客量："+totalBusload+"人");
			System.out.println("**********************");
			System.out.println("总载货量"+totalCargocapacity+"吨");
			System.out.println("租车总价格："+totalPrice+"元");
			System.out.println("==========布丁租车===============");
	}
	

}
}

