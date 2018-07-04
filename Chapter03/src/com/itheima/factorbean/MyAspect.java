package com.itheima.factorbean;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		check_Permissions();
		//执行目标方法
		Object obj = mi.proceed();
		log();
		return obj;
	}

	private void log() {
		// TODO Auto-generated method stub
		System.out.println("模拟记录日志...");
	}

	private void check_Permissions() {
		// TODO Auto-generated method stub
		System.out.println("模拟记录日志...");
	}

}
