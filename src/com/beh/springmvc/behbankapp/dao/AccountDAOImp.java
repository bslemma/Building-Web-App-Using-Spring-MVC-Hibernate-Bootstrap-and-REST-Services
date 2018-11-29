package com.beh.springmvc.behbankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beh.springmvc.behbankapp.entity.AccountEntity;
import com.beh.springmvc.behbankapp.models.Account;

@Repository
public class AccountDAOImp implements AccountDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean saveAccount(Account account) {
		// TODO Auto-generated method stub
		boolean saveFlag=true;
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setAccountNumber(account.getAccountNumber());
		accountEntity.setAccountHolderName(account.getAccountHolderName());
		accountEntity.setAccountBalance(account.getAccountBalance());
		try {
			Session currentSession=sessionFactory.getCurrentSession();
			currentSession.save(accountEntity);
			//currentSession.saveOrUpdate(accountEntity);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			saveFlag=false;
		}
		return saveFlag;
	}
	@Override
	public List<Account> getAccounts() {
		List<Account> list=new ArrayList<Account>();
		try {
			Session session=sessionFactory.getCurrentSession();
			Query<AccountEntity> query=session.createQuery("From AccountEntity",AccountEntity.class);
			List<AccountEntity> accounts=query.getResultList();
			for(int i=0;i<accounts.size();i++) {
				AccountEntity accountEntity=(AccountEntity) accounts.get(i);
				Account account=new Account();
				account.setAccountNumber(accountEntity.getAccountNumber());
				account.setAccountHolderName(accountEntity.getAccountHolderName());
				account.setAccountBalance(accountEntity.getAccountBalance());
				list.add(account);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Account getAccount(Integer accountNumber) {
		Account account=new Account();
		try {
			Session session=sessionFactory.getCurrentSession();
			AccountEntity accountEntity=(AccountEntity) session.get(AccountEntity.class, accountNumber);
			if(accountEntity==null) {
				return null;
			}
			account.setAccountNumber(accountEntity.getAccountNumber());
			account.setAccountHolderName(accountEntity.getAccountHolderName());
			account.setAccountBalance(accountEntity.getAccountBalance());
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return account;
	}
	@Override
	public boolean deleteAccount(int accountNumber) {
		boolean deleteFlag=true;
		try {
			Session session=sessionFactory.getCurrentSession();
			AccountEntity accountEntity=(AccountEntity) session.load(AccountEntity.class, accountNumber);
			session.delete(accountEntity);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			deleteFlag=false;
		}
		return deleteFlag;
	}

}
