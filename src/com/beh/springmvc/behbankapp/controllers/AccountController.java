package com.beh.springmvc.behbankapp.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beh.springmvc.behbankapp.models.Account;
import com.beh.springmvc.behbankapp.services.AccountService;
@Controller
public class AccountController {
	 
			@Autowired
			AccountService accountService;
			
			@InitBinder
			public void initBinder(WebDataBinder dataBinder) {
				StringTrimmerEditor ste=new StringTrimmerEditor(true);
				dataBinder.registerCustomEditor(String.class, ste);
			}
			
			@RequestMapping(value="find", method=RequestMethod.GET)
			public String viewAccount(Model model) {
				return "findAccount";
			}
	
			@RequestMapping("/")
			public String showHomePage() {
				return "index";
			}
			
			@RequestMapping("/new")
			public String newAccount(Model model) {
				model.addAttribute("account",new Account());
				return "account-form";
			}
			
			@RequestMapping("/showAccount")
			public String showAccount() {
				return "showAccount";
			}
	
			@RequestMapping(value="/saveAccount",method=RequestMethod.POST)
			public String saveAccount(@Valid @ModelAttribute("account") Account account, 
					BindingResult result,Model model) {
//				@RequestMapping(value="/saveAccount",method=RequestMethod.POST)
//				public String saveAccount(Model model, Account account) {
					
//					@RequestParam("accountNumber") String accNum,
//					@RequestParam("accountHolderName") String accHolderName,
//					@RequestParam("accountBalance") String accBalance
				
//				String accNum=servletRequest.getParameter("accountNumber");
//				String accHolderName=servletRequest.getParameter("accountHolderName");
//				String accBalance=servletRequest.getParameter("accountBalance");
				
//				model.addAttribute("accountNumber",accNum);
//				model.addAttribute("accountHolderName",accHolderName);
//				model.addAttribute("accountBalance", accBalance);
//				model.addAttribute("accountType", accBalance);
//				
//				Account account=new Account();
//				account.setAccountNumber(Integer.parseInt(accNum));
//				account.setAccountHolderName(accHolderName);
//				account.setAccountBalance(Integer.parseInt(accBalance));
				
				//model.addAttribute("account",account);	
//				 return "showAccount";
//				accountService.saveAccount(account);
//				return "redirect:/list";
			
//				}
				
//			   if(result.hasErrors()) {
//				   return "account-form";
//			   }
//				   
//			   else {
//				   accountService.saveAccount(account);
//			       return "redirect:/list";
//			   }
				
				if(result.hasErrors()) {
					return "account-form";
				}
				else {
					String message="";
					boolean flag=true;
					try {
						flag=accountService.saveAccount(account);
					}
					catch(Exception ex) {
						message=ex.getMessage();
						flag=false;
					}
					if(!flag) {
						model.addAttribute("message",message);
						return "account-form";
					}
					model.addAttribute("account",account);
					return "redirect:/list";
				}
				 
			}
			@GetMapping("/list")
			public String listAccounts(Model model) {
				List<Account> accounts=accountService.getAccounts();
				model.addAttribute("accounts",accounts);
				return "listAccounts";
			}
			@GetMapping("/edit")
			public String updateAccount(@RequestParam("accountNumber") int accountNumber,Model model) {
				Account account=accountService.getAccount(new Integer(accountNumber));
				model.addAttribute("account",account);
				return "account-form";
			}
			@GetMapping("/delete")
			public String deleteAccount(@RequestParam("accountNumber") int accountNumber,Model model) {
				accountService.deleteAccount(accountNumber);
				return "redirect:/list";
			}
			
			@ResponseBody
			@RequestMapping(value="/{id}", method=RequestMethod.GET)
			public Account getAccount(@PathVariable("id")Integer accountNumber) {
				System.out.println("Request Account Number: "+accountNumber);
				Account account=accountService.getAccount(accountNumber);
				return account;
			}
}
