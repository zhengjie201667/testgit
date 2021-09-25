package com.java.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
	//springaop自动的5种aop这里全部列出
	@Before("execution(* com.java.service.*.*(..))")
	public void before(){
	System.out.println("---------方法执行前before()---------");
	} 
	@After("execution(* com.java.service.*.*(..))")
	public void after(){
	System.out.println("---------方法执行后after()---------");
	} 
	@AfterReturning("execution(* com.java.service.*.*(..))")
	public void afterReturning(){
	System.out.println("---------方法返回后afterReturning()---------");
	} 
	@Around("execution(* com.java.service.*.*(..))")
	public void around(ProceedingJoinPoint jp) throws Throwable {
	System.out.println("-------环绕前-------");
	System.out.println("签名（拿到方法名）:"+jp.getSignature());
	//执行目标方法proceed
	Object proceed = jp.proceed();
	System.out.println("-------环绕后------");
	System.out.println(proceed);
	}
	@AfterThrowing("execution(* com.java.service.*.*(..))")
	public void afterThrow() {
	System.out.println("--------------有异常发生-----------------" + new Date());
	}
}
