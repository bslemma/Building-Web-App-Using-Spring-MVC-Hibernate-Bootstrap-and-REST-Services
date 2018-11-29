package com.beh.springmvc.behbankapp.services;

import java.util.List;

import com.beh.springmvc.behbankapp.models.Account;

public interface AccountService {
	public boolean saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(Integer accountNumber);
	public boolean deleteAccount(int accountNumber);
}
