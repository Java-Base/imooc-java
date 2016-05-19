package com.imooc.reflect.invok;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author	Lian
 * @time	2016年2月28日 下午9:45:46
 * @desc	方法反射
 */
public class MethodDemo1 {
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) {
		// 获取print(int, int)方法
		// 1. 要获取一个方法就是获取类的信息, 获取类的信息首先要获取类类型
		A a1 = new A();
		Class c = a1.getClass();
		/*
		 * 2. 获取方法 名称和参数列表来决定
		 * getMothod()获取的是public的方法
		 * getDeclaredMethod()获取的是自己声明的方法
		 */
		try {
//			Method m = c.getMethod("print", new Class[]{int.class, int.class});
			Method m = c.getMethod("print", int.class, int.class);

			// 方法的反射操作
			// obj.print(10, 20). 方法的反射操作时用Method对象来进行方法调用, 和用obj.print()调用的效果一样
			// 方如果没有返回值, 返回null; 有返回值则返回具体的返回值
//			m.invoke(a1, new Object[] {10, 20});
			m.invoke(a1, 10, 20);
			System.out.println("======================");
			Method m1 = c.getMethod("print", String.class, String.class);
			m1.invoke(a1, "hello", "world");
			System.out.println("======================");
			Method m2 = c.getMethod("print");
			m2.invoke(a1);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class A {
	public void print() {
		System.out.println("hello world");
	}

	public void print(int a, int b) {
		System.out.println(a+b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + ", " + b.toLowerCase());
	}
}
