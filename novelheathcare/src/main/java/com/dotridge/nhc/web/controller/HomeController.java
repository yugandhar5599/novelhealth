package com.dotridge.nhc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.nhc.web.model.LoginForm;

@Controller
public class HomeController {

	@RequestMapping(value = { "/novelhome" }, method = RequestMethod.GET)
	public String getHomePage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

}
