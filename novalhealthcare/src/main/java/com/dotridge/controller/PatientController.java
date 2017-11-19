package com.dotridge.controller;

import java.util.ArrayList;
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
import com.dotridge.bean.PatientBean;
import com.dotridge.bean.UserProfileBean;
import com.dotridge.service.PatientService;

@Controller
@RequestMapping("/patientMgmt")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/getAllPatients")
	public ModelAndView viewAllHospitals() {
		try {
			System.out.println("enter into controller");
			List<PatientBean> uipatientslist = patientService.getAllPatients();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getPatientBoard");
			System.out.println("list of patients" + uipatientslist);
			mav.addObject("uipatientslist", uipatientslist);
			return mav;
		} catch (Exception e) {

		}
		return null;
	}

	@RequestMapping("/getPatientRegForm")
	public String getPatientRegForm(Model model) {
		PatientBean patientBean = new PatientBean();
		model.addAttribute("patientBean", patientBean);
		populateDefaultModel(model);
		return "addPatientFormDef";
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public ModelAndView addPatient(@ModelAttribute("patientBean") PatientBean patientBean) {
		patientService.addPatient(patientBean);
		try {
			List<PatientBean> uipatientslist = patientService.getAllPatients();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getPatientBoard");
			System.out.println("list of patients" + uipatientslist.size());
			mav.addObject("uipatientslist", uipatientslist);
			return mav;
		} catch (Exception e) {

		}

		return null;

	}
	@RequestMapping("/editPatient")
	public String editAdmin(HttpServletRequest request, Model model) {
		String pId = request.getParameter("pId");

		System.out.println("patient Id..\t" + pId);
		PatientBean patientBean = patientService.getPatientById(Integer.valueOf(pId));
		System.out.println("PatientBean..\t" + patientBean.toString());
		populateDefaultModel(model);
		model.addAttribute("patientBean", patientBean);
		return "editPatientDef";
	}

	@RequestMapping("/deletePatient")
	public String deleteAdmin(HttpServletRequest request, Model model) {
		String pId = request.getParameter("pId");
		System.out.println("Patient delete Id..\t" + pId);
		patientService.deletePatient(Integer.valueOf(pId));
		return "redirect:getAllPatients";
	}

	@RequestMapping(value = "/updatePatient")
	public ModelAndView updateAdmin(@ModelAttribute("patientBean") PatientBean patientBean) {

		System.out.println("patientBean in controller is:\t" + patientBean.toString());
		patientService.updatePatient(patientBean);
		try {
			List<PatientBean> uipatientslist = patientService.getAllPatients();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getPatientBoard");
			System.out.println("list of users" + uipatientslist.size());
			mav.addObject("uipatientslist", uipatientslist);
			return mav;
		} catch (Exception e) {
		}
		return null;
	}

	private void populateDefaultModel(Model model) {
		List<String> bloodGroupList = new ArrayList<String>();
		bloodGroupList.add("A+");
		bloodGroupList.add("A-");
		bloodGroupList.add("B+");
		bloodGroupList.add("B-");
		bloodGroupList.add("AB+");
		bloodGroupList.add("AB-");
		bloodGroupList.add("O+");
		bloodGroupList.add("O-");
		model.addAttribute("bloodGroupList", bloodGroupList);
	}
}
