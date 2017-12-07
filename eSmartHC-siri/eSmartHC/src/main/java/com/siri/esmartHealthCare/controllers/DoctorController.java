/**
 * 
 */
package com.siri.esmartHealthCare.controllers;

import java.io.PrintStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.DoctorBean;
import com.siri.esmartHealthCare.beans.ManageUserProfileBean;
import com.siri.esmartHealthCare.constant.ActionRequestConstantService;
import com.siri.esmartHealthCare.constant.ViewRequestConstantService;
import com.siri.esmartHealthCare.services.DoctorServiceI;

/**
 * @author VENU
 *
 */
@Controller
public class DoctorController {
	@Autowired
	private DoctorServiceI docServ;
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	
	@PreAuthorize("hasAnyRole('admin','doctor')")
	 @RequestMapping(value=ActionRequestConstantService.DOCTOR_DETAILS_REQUEST)
	 	public ModelAndView getEditDoctorPage(){
	 		ModelAndView mav=new ModelAndView();
			List<DoctorBean> docbeanlist=docServ.getAllDoctors();
			mav.addObject("DoctorList", docbeanlist);
	 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
	 		return mav;
	 		
	 	}

	
	@RequestMapping(value=ActionRequestConstantService.ADD_DOCTOR_REQUEST)
	public ModelAndView addDoctor(){
		ModelAndView mav=new ModelAndView();
		DoctorBean dbean=new DoctorBean();
		mav.addObject("docBean", dbean);
		mav.setViewName(ViewRequestConstantService.ADD_DOCTOR_PAGE_REQUEST);
		return mav;
	}
	/*@RequestMapping(value=ActionRequestConstantService.SAVE_DOCTOR_DETAILS_REQUEST)
	public ModelAndView saveDoctors(@ModelAttribute("docBean") DoctorBean dbean){
		System.out.println("save doctor method is called");
		ModelAndView mav=new ModelAndView();
		System.out.println(dbean.getDocName());
		ManageUserProfileBean mupb=new ManageUserProfileBean();
		mupb.setFirstName(dbean.getDocName());
		mupb.setGender(dbean.getGender());
		mupb.setEmail(dbean.getEmail());
		docServ.addDoctor(dbean);
		List<DoctorBean> docbeanlist=docServ.getAllDoctors();
		mav.addObject("DoctorList", docbeanlist);
 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
		return mav;
	}
*/
	
	@RequestMapping(value=ActionRequestConstantService.SAVE_DOCTOR_DETAILS_REQUEST)
	public ModelAndView saveDoctor(@ModelAttribute("docBean") DoctorBean dbean){
		System.out.println("save doctor method is called");
		ModelAndView mav=new ModelAndView();
		System.out.println(dbean.getDocName());
		docServ.addDoctor(dbean);
		List<DoctorBean> docbeanlist=docServ.getAllDoctors();
		mav.addObject("DoctorList", docbeanlist);
 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
		return mav;
	}
	
	
	@RequestMapping(value="/getDoctorById")
	public ModelAndView editDoctorpage(){
		//System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		int docId=Integer.parseInt(request.getParameter("docId"));
		System.out.println("======================="+request.getParameter("docId"));
		ModelAndView mav=new ModelAndView();
		DoctorBean dbean=docServ.getDoctorById(docId);
		mav.addObject("doctorBean", dbean);
		//session.setAttribute("doctorBean", dbean);
		//DoctorBean docBean = new DoctorBean();
		
		mav.setViewName("views/editDoctor");
		//System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		return mav;
	}
	@RequestMapping(value=ActionRequestConstantService.UPDATE_DOCTOR_REQUEST)
	public ModelAndView updateDoctor(@ModelAttribute("doctorBean") DoctorBean doctorBean){
		ModelAndView mav=new ModelAndView();
		System.out.println("docid is"+doctorBean.getDocId());
		docServ.updateDoctor(doctorBean);
		List<DoctorBean> docbeanlist=docServ.getAllDoctors();
		mav.addObject("DoctorList", docbeanlist); 		
 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
		return mav;
	}
	/*@RequestMapping(value=ActionRequestConstantService.UPDATE_DOCTOR_REQUEST)
	public ModelAndView updateDoctor(@RequestParam("DocId") int docId,@RequestParam("DocName") String docName,@RequestParam("Email") String email,@RequestParam("Gender") String gender){
		ModelAndView mav=new ModelAndView();
		//System.out.println("=============================="+docId);
		//System.out.println("==============================="+docName);
		DoctorBean dbean=new DoctorBean();
		dbean.setDocId(docId);
		dbean.setDocName(docName);
		dbean.setEmail(email);
		dbean.setGender(gender);
		docServ.updateDoctor(dbean);
		List<DoctorBean> docbeanlist=docServ.getAllDoctors();
		mav.addObject("DoctorList", docbeanlist); 		
 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
		if(dbean.getDocId()>0){
			getEditDoctorPage();
		}
		return mav;
	}
*/	@RequestMapping(value=ActionRequestConstantService.DELETE_DOCTOR_BY_ID_REQUEST)
	public ModelAndView deleteDoctorById(){
		System.out.println("---------------------------------delete method is called");
		System.out.println("delete is called..."+request.getParameter("docId"));
		int docId=Integer.parseInt(request.getParameter("docId"));
		System.out.println(request.getParameter("docId"));
		ModelAndView mav=new ModelAndView();
		/*DoctorBean dbean=docServ.getDoctorById(docId);
	    docServ.deleteDoctor(dbean);*/
		String msg=docServ.deleteDoctor(docId);
		/*if(msg.equals("Success")){
		System.out.println("--------------------------------------delete successfully");
		}else{
			System.out.println("--------------------------------------delete faid");
		}*/
	    List<DoctorBean> docbeanlist=docServ.getAllDoctors();
		mav.addObject("DoctorList", docbeanlist); 		
 		mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
		//mav.addObject("doctorBean", dbean);
		//mav.setViewName("getEditDoctorPage");
		//mav.addObject("msg", msg);
		return mav;
	}
	 @RequestMapping(value=ActionRequestConstantService.SEARCH_DOCTOR_BY_NAME_REQUEST)
 	public ModelAndView searchDoctors(){
 		ModelAndView mav=new ModelAndView();
 	System.out.println(request.getParameter("searchValue"));	
 	String docName=request.getParameter("searchValue");
 	DoctorBean docbean=docServ.getDoctorByName(docName);
 	mav.addObject("docBean", docbean);	
 	mav.setViewName(ViewRequestConstantService.DOCTOR_DETAILS_PAGE_REQUEST);
 	//mav.setViewName("getSearchDoctor");
		return mav;
		}
	

}
