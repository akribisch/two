package com.web.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //切面
public class DynamicProxy {

	@Before("execution(* com.web.biz..*.*(..))")
	public void before(){
		System.out.println("在执行方法之前要做的事情");
	}
	
	
	@After("execution(* com.web.biz..*.*(..))")
	public void after(){
		System.out.println("在执行方法之后要做的事情");
	}
//	
//	@Around("execution(* com.web.biz..*.*(..))")
//	public void around(){
//		System.out.println("在执行方法之后要做的事情");
//	}
//	
	
}
