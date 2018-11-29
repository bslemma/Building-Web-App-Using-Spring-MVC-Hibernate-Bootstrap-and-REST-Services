package com.beh.springmvc.behbankapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BEHBankLoggingAspect {
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.beh.springmvc.behbankapp.contollers.*.*(..))")
	private void forControllersPackage() {
		
	}
	@Pointcut("execution(* com.beh.springmvc.behbankapp.services.*.*(..))")
	private void forServicesPackage() {
		
	}
	@Pointcut("execution(* com.beh.spingmvc.behbankapp.services.*.*(..))")
	private void forDAOPackage() {
		
	}
	@Pointcut("forControllersPackage() || forServicesPackage() || forDAOPackage()")
	private void forApplication() {
		
	}
	@Before("forApplication()")
	public void before(JoinPoint joinPoint) {
		String methodName=joinPoint.getSignature().toShortString();
		logger.info("Information: In @Before Advice: Calling the Method: "+ methodName);
	}
	@AfterReturning(pointcut="forApplication()", returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName=joinPoint.getSignature().toShortString();
		logger.info("Info: In @AfterReturning: From Method : "+methodName);
		logger.info("Info: Data returned by method : " +result);
	}
}
