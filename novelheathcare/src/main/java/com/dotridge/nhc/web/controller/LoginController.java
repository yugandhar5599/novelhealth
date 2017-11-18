package com.dotridge.nhc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dotridge.nhc.persistence.entity.User;
import com.dotridge.nhc.service.UserService;
import com.dotridge.nhc.web.model.LoginForm;

@Controller
public class LoginController {

	@Autowired
	private UserService loginService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String userLoginAction(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, Model model,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "login";
		}

		User user = loginService.getUserByName(loginForm.getUserName());
		boolean isValidCredentials = (user != null && user.getUserName().equals(loginForm.getUserName())
				&& user.getPassword().equals(loginForm.getPassword())) ? true : false;
		if (isValidCredentials) {
			HttpSession session = request.getSession(true);
			session.setAttribute("name", user.getFullName());
			switch (user.getRole()) {
			case "superadmin":
				return "superAdminHome";

			case "admin":
				return "superAdminHome";

			default:
				break;
			}

		}
		model.addAttribute("msg", "username (or) password entered is wrong");
		return "login";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String userLogoutAction(HttpServletRequest request, Model model) {
		request.getSession(false).invalidate();
		model.addAttribute("loginBean", new LoginForm());
		return "redirect:novelhome";
	}

}
