package com.beh.springmvc.behbankapp.dao;

import java.util.List;

import com.beh.springmvc.behbankapp.models.Account;

public interface AccountDAO {
	public boolean saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(Integer accountNumber);
	public boolean deleteAccount(int accountNumber);

}
