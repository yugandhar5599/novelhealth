/**
 * 
 */
package com.dotridge.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotridge.bean.LoginBean;
import com.dotridge.bean.UserProfileBean;

/**
 * @author Narsaiah
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value="/home")
	public String getHomePage() {
		
		return "home";
		
	}
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage(Model model){
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}
	
	@RequestMapping(value="/login")
	public String doLogin(@ModelAttribute("loginBean") LoginBean loginBean){
		System.out.println(loginBean.toString());
		String userName=loginBean.getUserId();
		if(userName !=null & !userName.isEmpty()){
			if(userName.equalsIgnoreCase("superadmin@email.com")){
				return "getSuperAdminBoard";
			}
			else if(userName.equalsIgnoreCase("admin@email.com")){
				System.out.println("enter into admin");
				return "getAdminPatientBoard";
			}
		}
		return "home";
	}
	
	@RequestMapping(value="/getSignUpPage")
	public String getSingUp(Model model){
		model.addAttribute("signupBean", new UserProfileBean());
		return "mysignup";
		
	}
	
	@RequestMapping(value="/signup")
	public String doSignUp(@ModelAttribute("signupBean") UserProfileBean userProfileBean){
		System.out.println(userProfileBean);
		return "mysignup";
		
	}
	public void m() throws SQLException{
		DataSource ds=new DriverManagerDataSource();
		ds.getConnection();
	}
	
}
