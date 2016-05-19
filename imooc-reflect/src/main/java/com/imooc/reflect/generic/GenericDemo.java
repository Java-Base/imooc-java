package com.imooc.reflect.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author	Lian
 * @time	2016年2月28日 下午10:02:32
 * @desc	通过Class, Method认识泛型的本质
 */
public class GenericDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(100);
//		list1.add(10);
		Class c1 = list.getClass();
		Class c2 = list1.getClass();
		System.out.println(c1 == c2);
		// 反射的操作都是编译之后的操作

		/*
		 * c1==c2结果返回true说明编译之后集合的泛型是去泛型化
		 * Java中集合的泛型, 是防止错误输入的, 只在编译阶段有效, 绕过编译就无效了
		 * 验证: 我们可以通过方法的反射来操作, 绕过编译
		 */

		try {
			Method m = c2.getMethod("add", Object.class);
			m.invoke(list1, "hello");	// 绕过编译操作就绕过了泛型
			System.out.println(list1.size());
			System.out.println(list1);
			for(Integer num : list1) {
				System.out.println(num);
			}
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
