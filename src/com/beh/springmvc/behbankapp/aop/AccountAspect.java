package com.beh.springmvc.behbankapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.beh.springmvc.behbankapp.dao.AccountDAO;
import com.beh.springmvc.behbankapp.models.Account;

@Aspect
@Component
public class AccountAspect {
	
	@Before("execution (* com.beh.springmvc.behbankapp.dao.AccountDAOImp.saveAccount(..))")
	public void validateAccount(JoinPoint joinPoint) {
		System.out.println("Method: ValidateAccount is being processed");
		Object []args=joinPoint.getArgs();
		Account account=(Account) args[0];
		AccountDAO accountDAO=(AccountDAO) joinPoint.getTarget();
		int accountNumber=account.getAccountNumber();
		if(accountDAO.getAccount(accountNumber)!=null) {
			throw new RuntimeException("Account with Account Number "+accountNumber+" is already exists");
		}
	}

}
