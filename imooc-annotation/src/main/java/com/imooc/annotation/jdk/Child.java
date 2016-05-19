package com.imooc.annotation.jdk;


/**
 * @author	Lian
 * @time	2016年2月28日 下午10:21:33
 * @desc	
 */
public class Child implements Person {

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sing() {
		System.out.println("Child sing");
	}

}
