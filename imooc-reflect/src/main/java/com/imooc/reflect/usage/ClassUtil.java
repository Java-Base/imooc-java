package com.imooc.reflect.usage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author	Lian
 * @time	2016年2月28日 下午7:10:01
 * @desc	获取类的全部信息
 */
public class ClassUtil {
	/**
	 * 打印对象的成员函数信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printMethodMessage(Object obj) {
		// 要获取类的信息, 首先要获取类的类类型
		Class c = obj.getClass();	// 传递的是哪个子类的对象, c就是该子类的类型

		System.out.println("类的名称是: " + c.getName());

		/**
		 * Method类, 方法对象
		 * 一个成员方法就是一个Method对象
		 * getMothods()获取的是所有的public函数, 包括父类继承而来的
		 * c.getDeclaredMethods()获取的是所有该类自己声明的方法, 不问访问权限
		 */
		Method[] ms = c.getMethods();
//		c.getDeclaredMethods();
		System.out.println("*************** Methods *******************");
		for(Method m : ms) {
			// 得到方法的返回值类型的类类型
			Class returnType = m.getReturnType();
			System.out.println("返回值类型名称: " + returnType.getName());
			// 得到方法名称
			System.out.println("方法名称: " + m.getName());
			// 获取参数类型-->得到是参数列表的类型的类类型
			Class[] paramTypes = m.getParameterTypes();
			System.out.print("方法参数为: ");
			for(Class type : paramTypes) {
				System.out.print(type.getName() + ", ");
			}
			System.out.println("\n");
		}
	}

	/**
	 * 打印对象的成员变量信息
	 * @param c
	 */
	@SuppressWarnings("rawtypes")
	public static void printFieldMessage(Object obj) {
		System.out.println("*************** Fields *******************");

		/**
		 * 成员变量也是对象
		 * java.lang.reflect.Field
		 * Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有的public的成员变量的信息\
		 * getDeclaredFields()方法获取的是该类自己声明的成员变量的信息
		 */
		Class c = obj.getClass();
//		Field[] fs = c.getFields();
		Field[] fs = c.getDeclaredFields();
		for(Field field : fs) {
			// 得到成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			// 得到成员变量的名称
			String fieldName = field.getName();
			System.out.println("成员变量的类型: " + typeName + ", 成员变量的名称: " + fieldName);
			System.out.println();
		}
	}

	/**
	 * 打印对象的构造函数的信息
	 * @param obj
	 */
	@SuppressWarnings("rawtypes")
	public static void printConstructorMessage(Object obj) {
		System.out.println("*************** Constructors *******************");
		Class c = obj.getClass();

		/**
		 * 构造函数也是对象
		 * java.lang.Constructor中封装了构造函数的信息
		 * getConstructors()获取所有的public的构造函数
		 * getDeclaredConstructors()获取所有的构造函数
		 * 
		 */
//		Constructor[] cons = c.getConstructors();
		Constructor[] cons = c.getDeclaredConstructors();
		for(Constructor con : cons) {
			System.out.print(con.getName() + "(");

			// 获取构造函数的参数列表-->得到的是参数列表的类类型
//			for(Parameter para : con.getParameters()) {
//				System.out.print(para.getType() + " " + para.getName() + ", ");
//			}
			for(Class type : con.getParameterTypes()) {
				System.out.print(type.getName() + ",");
			}
			System.out.print(")\n");
		}
	}
}
