package com.siri.esmartHealthCare.controllers;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.services.SignupServicesI;

@Controller
public class HomeController {
	@Autowired
	private SignupServicesI signupSer;
	@Autowired
	private JavaMailSender mailSender;
	
	/*@Autowired
	private HttpServletRequest request;*/
	
	
	String message = "";
	@RequestMapping(value = "/home")
	public ModelAndView getHomePage() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("views/home");
		return mav;
	}

	@RequestMapping(value = "/getSignUpPage")
	public ModelAndView getSignUpPage() {
		System.out.println("sign up is called...");
		//SignupBean signup = new SignupBea()
		ManageUserProfileBean userProfBean = new ManageUserProfileBean();
		
		ModelAndView mav = new ModelAndView();
		//List<String> deptListOfNames = signupSer.getDepList();
		//List<String> listOfRoles = signupSer.getRoleList();
		/*for (String deprartmentName : listOfRoles) {
			System.out.println(deprartmentName);
		}*/
		
		mav.addObject("userProfBean", userProfBean);
		//mav.addObject("roleList", listOfRoles);
		//mav.addObject("deptList", deptListOfNames);
		mav.setViewName("getSignup");
		return mav;
	}
	
	@RequestMapping(value="/signupPage",method=RequestMethod.POST)
	public ModelAndView signupPage(@Valid @ModelAttribute("userProfBean") ManageUserProfileBean userProfBean,BindingResult bindResult ) throws Exception{
		ModelAndView mav = new ModelAndView();
		if(bindResult.hasErrors()){
			
			mav.setViewName("getSignup");
			return mav;
		}else{
			
			String emiailId = userProfBean.getEmail();
			System.out.println("emiailId  "+emiailId);
			Integer roleId = signupSer.getRoleId();
			String msg = signupSer.saveDetails(userProfBean);
			
			if(msg.equals("mailExist")){
				message = "Email id already existed";
				mav.addObject("message", message);
				mav.setViewName("getSignup");
				return mav;
			}else {
				if(msg.equals("uIdexist")){
					message="userId allready exist";
					mav.addObject("message1", message);
					mav.setViewName("getSignup");
					return mav;
					
				}else{
				
			if(msg.equals("success")){
				InetAddress address = (InetAddress)InetAddress.getLocalHost();
				 String hostIP = address.getHostAddress() ;
				    System.out.println(hostIP);
				
				SimpleMailMessage emailDetails = new SimpleMailMessage();
				//emailDetails.setFrom("venumca13@gmail.com");
				emailDetails.setTo(emiailId);
				emailDetails.setSubject("email verification");
				emailDetails.setText("please click on below link for login  http://"+hostIP+":8080/esmartHealthCare/login ");
				System.out.println("ip address:  "+InetAddress.getLocalHost());
				
				mailSender.send(emailDetails);
				String [] s =emiailId.split("@");
				String domaineName = s[1];
				System.out.println("domaine name: "+s[1]);
				message = "registration is successfully completed. ";
				mav.addObject("domaineName", domaineName);
			}else{
				
				message = "registration is failed";
			}
			
			
			mav.addObject("message", message);
			mav.setViewName("getResult");
		}
		}	
		}
		
		//System.out.println("signup page is called");
		//System.out.println(signup.getFirstname());
		/*SignupBean sbean=new SignupBean();
		sbean.setFirstname(signup.getFirstname());
		sbean.setMiddlename(signup.getMiddlename());
		sbean.setLastname(signup.getLastname());
		sbean.setDepartment(signup.getDepartment());
		sbean.setGender(signup.getGender());
		sbean.setUserid(signup.getUserid());
		sbean.setPassword(signup.getPassword());
		sbean.setAcceptTerm(signup.getAcceptTerm());*/
		//ModelAndView mav = new ModelAndView();
		//System.out.println(signup.getFirstname());
		return mav;
	}
	
	@RequestMapping(value="/getDeptNames")
	//@ResponseBody
	public @ResponseBody List<String> getDeptList(HttpServletRequest request){
		String role = request.getParameter("role");
		
		//System.out.println("getDeptList is called..."+role);
	/*ModelAndView mav=new ModelAndView();
	mav.setViewName("getLogin");*/
	List<String> deptListOfNames = signupSer.getDepList(role);
	
	return deptListOfNames;
	}
	@RequestMapping(value="/outPatientLogin")
	public ModelAndView getLoginPage(){
	ModelAndView mav=new ModelAndView();
	mav.setViewName("getLogin");
	return mav;
	}
}
