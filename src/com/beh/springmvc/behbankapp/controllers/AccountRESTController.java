package com.beh.springmvc.behbankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.beh.springmvc.behbankapp.models.Account;
import com.beh.springmvc.behbankapp.services.AccountService;

//@Controller
@RestController
@RequestMapping(value="account")
public class AccountRESTController {
	@Autowired
	private AccountService accountService;
	
//	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ResponseEntity<Account> getAccount(@RequestBody Account accnt) {
		System.out.println("Request Account Number: "+accnt.getAccountNumber());
		Account account=accountService.getAccount(accnt.getAccountNumber());
		if(account==null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account,HttpStatus.OK);
	}
}
