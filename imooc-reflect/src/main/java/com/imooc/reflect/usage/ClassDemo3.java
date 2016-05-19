package com.imooc.reflect.usage;

/**
 * @author	Lian
 * @time	2016年2月28日 下午7:20:50
 * @desc	
 */
public class ClassDemo3 {
	public static void main(String[] args) {
//		String s = "hello";
//		ClassUtil.printClassMessage(s);

		Integer n1 = 1;
		ClassUtil.printMethodMessage(n1);

		ClassUtil.printConstructorMessage("hello");
		ClassUtil.printConstructorMessage(1);
	}
}
