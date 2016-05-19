package com.imooc.annotation.jdk;

/**
 * @author	Lian
 * @time	2016年2月28日 下午10:20:42
 * @desc	父类接口
 */
public interface Person {
	public String name();

	public int age();

	@Deprecated
	public void sing();
}
