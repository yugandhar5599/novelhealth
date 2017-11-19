package com.dotridge.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dotridge.bean.HospitalBean;
import com.dotridge.bean.UserProfileBean;
import com.dotridge.service.HospitalService;
import com.dotridge.service.UserService;

@Controller
@RequestMapping("/userMgmt")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = "/getAllUsers")
	public ModelAndView viewAllAdmins() {
		try {
			System.out.println("Enter into User Controller");
			List<UserProfileBean> uiadminslist = userService.getAllUsers();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getAdminBoard");
			mav.addObject("uiadminslist", uiadminslist);
			return mav;
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping("/getAdminRegForm")
	public String getAdminRegForm(Model model) {
		UserProfileBean adminBean = new UserProfileBean();
		List<HospitalBean> uihosplist = hospitalService.getAllHospital();
		Set<String> hospitalNames = getAllHospitalNames(uihosplist);
		model.addAttribute("hospitalNames", hospitalNames);
		model.addAttribute("adminBean", adminBean);
		return "addAdminFormDef";
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public String addAdmin(@ModelAttribute("adminBean") UserProfileBean userProfileBean, Model model) {
		userProfileBean = userService.addUser(userProfileBean);
		List<UserProfileBean> uiadminslist = null;
		try {
			if (userProfileBean.getAdminId() > 0) {
				uiadminslist = userService.getAllUsers();
			}
		} catch (Exception e) {
		}
		model.addAttribute("uiadminslist", uiadminslist);
		return "getAdminBoard";

	}

	private Set<String> getAllHospitalNames(List<HospitalBean> hospitalbeans) {
		Set<String> hospitalNames = new HashSet<String>();
		Iterator<HospitalBean> hospBeans = hospitalbeans.iterator();
		while (hospBeans.hasNext()) {
			String hospitalName = hospBeans.next().getHospitalName();
			if (hospitalName != null) {
				hospitalNames.add(hospitalName);
			}
		}
		return hospitalNames;

	}

	@RequestMapping("/editAdmin")
	public String editAdmin(HttpServletRequest request, Model model) {
		String adminId = request.getParameter("adminId");

		System.out.println("Admin Id..\t" + adminId);
		UserProfileBean adminBean = userService.getUserById(Integer.valueOf(adminId));
		System.out.println("UserProfileBean..\t" + adminBean.toString());
		List<HospitalBean> uihosplist = hospitalService.getAllHospital();
		Set<String> hospitalNames = getAllHospitalNames(uihosplist);
		model.addAttribute("hospitalNames", hospitalNames);
		model.addAttribute("adminBean", adminBean);
		return "editAdminDef";
	}

	@RequestMapping("/deleteAdmin")
	public String deleteAdmin(HttpServletRequest request, Model model) {
		String adminId = request.getParameter("adminId");
		System.out.println("Admin delete Id..\t" + adminId);
		userService.deleteUser(Integer.valueOf(adminId));
		return "redirect:getAllUsers";
	}

	@RequestMapping(value = "/updateAdmin")
	public ModelAndView updateAdmin(@ModelAttribute("adminBean") UserProfileBean userProfileBean) {

		System.out.println("adminBean in controller is:\t" + userProfileBean.toString());
		userService.updateUser(userProfileBean);
		try {
			List<UserProfileBean> uiadminslist = userService.getAllUsers();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getAdminBoard");
			System.out.println("list of users" + uiadminslist.size());
			mav.addObject("uiadminslist", uiadminslist);
			return mav;
		} catch (Exception e) {
		}
		return null;
	}
}
