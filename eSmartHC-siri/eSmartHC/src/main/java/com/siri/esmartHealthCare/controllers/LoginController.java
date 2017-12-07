/**
 * 
 */
package com.siri.esmartHealthCare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.beans.LoginBean;
import com.siri.esmartHealthCare.beans.MedicinesBean;
import com.siri.esmartHealthCare.beans.PatientBean;
import com.siri.esmartHealthCare.services.DoctorServiceI;
import com.siri.esmartHealthCare.services.LoginServiceI;
import com.siri.esmartHealthCare.services.MedicinesService;
import com.siri.esmartHealthCare.services.PatientServiceI;

/**
 * @author VENU
 *
 */
@Controller
public class LoginController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private PatientServiceI patientServ;
	@Autowired
	private DoctorServiceI docser;
	@Autowired
	private MedicinesService mediser;
	@Autowired
	private LoginServiceI loginSer;

	private ModelAndView mav = null;
	@RequestMapping(value="/getLoginPage")
	//public ModelAndView getLoginPage(HttpSession ses){
		public ModelAndView getLoginPage(){
		//ses.setAttribute("role", arg1);
	LoginBean loginBean = new LoginBean();
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String userName = auth.getName();
	System.out.println("logged in user name is:\t"+userName);
	if(userName != null && !userName.isEmpty() && !userName.equals("anonymousUser")){
		return new ModelAndView("redirect:/secure/getAllUserProcessInfo");
	}
	 
	ModelAndView mav=new ModelAndView();
	mav.addObject("loginBean", loginBean);
	mav.setViewName("views/login");
	return mav;
	}
	
	
	@PreAuthorize("hasAnyRole('admin','staff')")
	@RequestMapping(value="/secure/getAllUserProcessInfo")
	public ModelAndView getAllUserProcessInfo(@ModelAttribute("login") LoginBean loginBean){
		//System.out.println("loginBean  name:"+loginBean.getUserId());
		/*String roleName = loginSer.getRoleNameByUserId(loginBean.getUserId());
		System.out.println("roleName   "+roleName);*/
		String roleName = "";
		Authentication auth=   SecurityContextHolder.getContext().getAuthentication();
		System.out.println("PRINCIPAL IS:\t"+auth.getPrincipal().toString());
	
		//ManageUserProfileBean userDetails = (ManageUserProfileBean) auth.getPrincipal();
		//UsernamePasswordAuthenticationToken userDetails = (UsernamePasswordAuthenticationToken) auth.getPrincipal();
		
		String userName = auth.getName();
		System.out.println("user name is:\t"+userName);
		for(GrantedAuthority ga : auth.getAuthorities()){
			roleName = ga.getAuthority();
		}
		
		if(roleName.equals("admin")){
			
			 mav=new ModelAndView();
			List<PatientBean> pbeanlist=patientServ.getAllPatient();
			mav.setViewName("getAdmin");
			
			}
		if(roleName.equals("staff")){
			
			 mav=new ModelAndView();
			 //PatientBean pBean=new PatientBean();
			 //mav.addObject("patientBean", pBean);
			//List<PatientBean> pbeanlist=patientServ.getAllPatient();
			mav.setViewName("getStaff");
			
			}
		
		if(roleName.equals("doctor")){
			
			 mav=new ModelAndView();
			List<PatientBean> pbeanlist=patientServ.getAllPatient();
			for(PatientBean pbean:pbeanlist){
				System.out.println(pbean.getPname());
				System.out.println(pbean.getPid());
				System.out.println(pbean.getEmail());
				System.out.println(pbean.getGender());
				System.out.println(pbean.getModifiedBy());
				//System.out.println(pbean.getCreatedDate());
				//System.out.println(pbean.getLastModifiedDate());
				//System.out.println(pbean.getDateofbirth());
				
			}
			mav.addObject("PatientList", pbeanlist);
			mav.setViewName("getPatients");
			//return mav;
			
		}
		if(roleName.equals("outpatient")){
			mav=new ModelAndView();
			List<DoctorBean> docbeanlist=docser.getAllDoctors();
			for(DoctorBean docbean:docbeanlist){
				System.out.println(docbean.getDocId());
				System.out.println(docbean.getDocName());
				System.out.println(docbean.getEmail());
				System.out.println(docbean.getGender());
				System.out.println(docbean.getMobilenumber());
				
			}
			mav.addObject("DoctorList", docbeanlist);
			mav.setViewName("getDoctors");
			
		}
		
		if(roleName.equals("inpatient")){
			mav=new ModelAndView();
			List<DoctorBean> docbeanlist=docser.getAllDoctors();
			for(DoctorBean docbean:docbeanlist){
				System.out.println(docbean.getDocId());
				System.out.println(docbean.getDocName());
				System.out.println(docbean.getEmail());
				System.out.println(docbean.getGender());
				System.out.println(docbean.getMobilenumber());
			}
			mav.addObject("DoctorList", docbeanlist);
			mav.setViewName("getDoctors");
		}
		if(roleName.equals("pharmacy")){
			mav=new ModelAndView();
			mav.setViewName("getPharmacy");
			/*List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
			for(MedicinesBean medibean:medicinebeanlist){
				System.out.println(medibean.getMedicineId());
				System.out.println(medibean.getMedicineName());
				System.out.println(medibean.getManifactureDate());
				System.out.println(medibean.getExpiredDate());
			}
			mav.addObject("MedicinesList", medicinebeanlist);
			mav.setViewName("getMedicines");	*/
			
		}
		return mav;
	}
	@RequestMapping(value="/getPatients")
	public ModelAndView getAllPatients(){
		ModelAndView mav=new ModelAndView();
		List<PatientBean> pbeanlist=patientServ.getAllPatient();
		for(PatientBean pbean:pbeanlist){
			System.out.println(pbean.getPname());
			System.out.println(pbean.getPid());
			System.out.println(pbean.getEmail());
			System.out.println(pbean.getGender());
			System.out.println(pbean.getModifiedBy());
			//System.out.println(pbean.getCreatedDate());
			//System.out.println(pbean.getLastModifiedDate());
			//System.out.println(pbean.getDateofbirth());
			
		}
		mav.addObject("PatientList", pbeanlist);
		mav.setViewName("getPatients");
		return mav;
		
	}
	
	@RequestMapping(value="/getDoctors")
	public ModelAndView getAllDoctors(){
		ModelAndView mav=new ModelAndView();
		List<DoctorBean> docbeanlist=docser.getAllDoctors();
		for(DoctorBean docbean:docbeanlist){
			System.out.println(docbean.getDocId());
			System.out.println(docbean.getDocName());
			System.out.println(docbean.getEmail());
			System.out.println(docbean.getGender());
			System.out.println(docbean.getMobilenumber());
			//System.out.println(pbean.getCreatedDate());
			//System.out.println(pbean.getLastModifiedDate());
			//System.out.println(pbean.getDateofbirth());
			
		}
		mav.addObject("DoctorList", docbeanlist);
		mav.setViewName("getDoctors");
		return mav;
		
	}

     @RequestMapping(value="/getMedicines")
	public ModelAndView getAllMediciness(){
		ModelAndView mav=new ModelAndView();
		List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
		for(MedicinesBean medibean:medicinebeanlist){
			System.out.println(medibean.getMedicineId());
			System.out.println(medibean.getMedicineName());
			System.out.println(medibean.getManifactureDate());
			System.out.println(medibean.getExpiredDate());
		}
		mav.addObject("MedicinesList", medicinebeanlist);
		mav.setViewName("getMedicines");
		return mav;
		
	}

        /* @RequestMapping(value="/getEditPharmaPage")
  	public ModelAndView getEditPharmaPage(){
  		ModelAndView mav=new ModelAndView();
  		List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
		for(MedicinesBean medibean:medicinebeanlist){
			System.out.println(medibean.getMedicineId());
			System.out.println(medibean.getMedicineName());
			System.out.println(medibean.getManifactureDate());
			System.out.println(medibean.getExpiredDate());
		}
		mav.addObject("MedicinesList", medicinebeanlist);
		mav.setViewName("getEditPharma");
		return mav;
 		}
*/
    /* @RequestMapping(value="/getEditStaffPage")
   	public ModelAndView getEditStaffPage(){
   		ModelAndView mav=new ModelAndView();
 		mav.setViewName("getEditStaff");
 		return mav;
  		}*/
    
}
