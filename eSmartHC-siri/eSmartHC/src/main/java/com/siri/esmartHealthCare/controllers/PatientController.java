/**
 * 
 */
package com.siri.esmartHealthCare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.PatientBean;
import com.siri.esmartHealthCare.beans.RoleBean;
import com.siri.esmartHealthCare.services.PatientServiceI;
import com.siri.esmartHealthCare.services.RoleServiceI;

/**
 * @author VENU
 *
 */
@Controller
public class PatientController {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private RoleServiceI rserv;
	
	@Autowired
	private PatientServiceI pserv;
	
	 @RequestMapping(value="/getInpatientPage")
	 public ModelAndView addInpatient(){
		ModelAndView mav=new ModelAndView();
		PatientBean pBean=new PatientBean();
		 mav.addObject("patientBean", pBean);
		 System.out.println(request.getParameter("value"));
			String roleName=request.getParameter("value");
			List<String> pnameList=rserv.getRoleByNames(roleName);
			for(String s:pnameList){
				System.out.println(s);
			}
			mav.addObject("pnameList", pnameList);
		 mav.setViewName("getAddPatientPage");
		return mav;
	 }
	 @RequestMapping(value="/getOutpatientPage")
	 public ModelAndView addOutpatient(){
		ModelAndView mav=new ModelAndView();
		PatientBean pBean=new PatientBean();
		 mav.addObject("patientBean", pBean);
		 System.out.println(request.getParameter("value"));
			String roleName=request.getParameter("value");
			List<String> pnameList=rserv.getRoleByNames(roleName);
			for(String s:pnameList){
				System.out.println(s);
			}
			mav.addObject("pnameList", pnameList);
		 mav.setViewName("getAddPatientPage");
		return mav;
	 }
	 
	 @RequestMapping(value="/saveInPatientdetails")
	 public ModelAndView saveInpatient(@ModelAttribute("patientBean") PatientBean patientBean)
	 {
		 System.out.println(patientBean.getPname());
		 System.out.println(patientBean.getGender());
		 System.out.println(patientBean.getMobile());
		 System.out.println(patientBean.getRole());
		ModelAndView mav=new ModelAndView();
		pserv.addPatient(patientBean);
		return mav;
	 }
}
