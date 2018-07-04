package com.itheima.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.itheima.aspect.MyAspect;

public class JdkProxy implements InvocationHandler{

	//声明目标类接口
	private UserDao userDao;
	//创建代理方法
	public Object createProxy(UserDao userDao) {
		this.userDao = userDao;
		//1.类加载器	
		ClassLoader classLoader = JdkProxy.class.getClassLoader();
		//2.被代理对象实现的所有
		Class[] clazz = userDao.getClass().getInterfaces();
		//3.使用代理类，进行增强，返回的是代理后的对象
		return Proxy.newProxyInstance(classLoader, clazz, this);	
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 * 所有的代理类的方法调用。都会交由invoke()方法处理
	 * proxy被代理对象
	 * method将要被执行的方法信息(反射)
	 * args执行方法时的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//声明切面
		MyAspect myAspect = new MyAspect();
		//前增强
		myAspect.check_Permissions();
		//在目标类上调用方法，并传入参数
		Object object = method.invoke(userDao, args);
		//后增强
		myAspect.log();
		return null;
	}

}
