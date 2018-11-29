package com.beh.springmvc.behbankapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beh.springmvc.behbankapp.dao.AccountDAO;
import com.beh.springmvc.behbankapp.models.Account;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	@Transactional
	public boolean saveAccount(Account account) {
		return accountDAO.saveAccount(account);
	}

	@Override
	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Override
	@Transactional
	public Account getAccount(Integer accountNumber) {
		return accountDAO.getAccount(accountNumber);
	}

	@Override
	@Transactional
	public boolean deleteAccount(int accountNumber) {
		return accountDAO.deleteAccount(accountNumber);
	}

}
