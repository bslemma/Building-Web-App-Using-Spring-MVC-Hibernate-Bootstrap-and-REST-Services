package com.beh.springmvc.behbankapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/new")
	public String register() {
		return "register";
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
						@RequestParam(value="logout", required=false) String logout,Model model) {
		if(error!=null) {
			model.addAttribute("error","Invalid Username or Password");
		}
		if(logout!=null) {
			model.addAttribute("msg","You have been logout successfully");
		}
		return "login";
	}
}
