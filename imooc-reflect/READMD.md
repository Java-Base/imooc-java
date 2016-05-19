反射——Java高级开发必须懂的

http://www.imooc.com/learn/199

1. Class类
	1) 在面向对象的世界里, 万事万物皆对象. (java语言中, 静态的成员.普通?)
	  类是不是对象呢? 类是(哪个类的对象呢?)谁的对象呢?
	  类是对象, 类是java.lang.Class类的实例对象
	2) 这个对象到底如何表示, 有三种方式(比如有个类Person):
		a) Person.class;
		b) new Person().getClass();
		c) Class.forName("***.***.Person")

2. Class.forName("类的全称")
	* 不仅表示了类的类类型, 还代表了动态加载类
	* 请大家区分编译.运行
	* 编译时刻加载类是静态加载类, 运行时刻加载类是动态加载类

3. Class类的使用
	* 方法的反射
		** 如何获取某个方法
			方法的名称和方法的参数列表才能唯一决定某个方法
		** 方法反射的操作
			method.invoke(对象, 参数列表)
	* 成员变量的反射
	* 构造函数的返时
	* Java类加载机制

4. 基本的数据类型, void关键字, 都存在类类型

5. Class的基本API操作