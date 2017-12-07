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

import com.siri.esmartHealthCare.beans.StaffBean;
import com.siri.esmartHealthCare.constant.ActionRequestConstantService;
import com.siri.esmartHealthCare.constant.ViewRequestConstantService;
import com.siri.esmartHealthCare.services.StaffService;

/**
 * @author VENU
 *
 */
@Controller
public class StaffController {
	@Autowired
	private StaffService staffServ;
	@Autowired
	private HttpServletRequest request;
	
	 @RequestMapping(value=ActionRequestConstantService.STAFF_DETAILS_REQUEST)
	 	public ModelAndView getEditDoctorPage(){
	 		ModelAndView mav=new ModelAndView();
			List<StaffBean> staffbeanlist=staffServ.getAllStaffs();
			mav.addObject("StaffList", staffbeanlist);
	 		mav.setViewName(ViewRequestConstantService.STAFF_DETAILS_PAGE_REQUEST);
	 		return mav;
	 		
	 	}

	
	@RequestMapping(value=ActionRequestConstantService.ADD_STAFF_REQUEST)
	public ModelAndView addStaff(){
		ModelAndView mav=new ModelAndView();
		StaffBean sbean=new StaffBean();
		mav.addObject("staffBean", sbean);
		mav.setViewName(ViewRequestConstantService.ADD_STAFF_PAGE_REQUEST);
		return mav;
	}
	
	@RequestMapping(value=ActionRequestConstantService.SAVE_STAFF_DETAILS_REQUEST)
	public ModelAndView saveStaff(@ModelAttribute("staffBean") StaffBean sbean){
		System.out.println("save staff method is called");
		ModelAndView mav=new ModelAndView();
		System.out.println(sbean.getName());
		staffServ.addStaff(sbean);
		List<StaffBean> staffbeanlist=staffServ.getAllStaffs();
		mav.addObject("StaffList", staffbeanlist);
 		mav.setViewName(ViewRequestConstantService.STAFF_DETAILS_PAGE_REQUEST);
		return mav;
	}
	
	@RequestMapping(value=ActionRequestConstantService.STAFF_BY_ID_REQUEST)
	public ModelAndView editDoctorpage(){
		int staffId=Integer.parseInt(request.getParameter("staffId"));
		System.out.println(request.getParameter("staffId"));
		ModelAndView mav=new ModelAndView();
		StaffBean sbean=staffServ.getStaffById(staffId);
		mav.addObject("staffBean", sbean);
		mav.setViewName(ViewRequestConstantService.EDIT_STAFF_PAGE_REQUEST);
		return mav;
	}
	@RequestMapping(value=ActionRequestConstantService.UPDATE_STAFF_REQUEST)
	public ModelAndView updateDoctor(@ModelAttribute("staffBean") StaffBean staffBean){
		ModelAndView mav=new ModelAndView();
		System.out.println("docid is"+staffBean.getStaffId());
		StaffBean sbean=staffServ.updateStaff(staffBean);
		List<StaffBean> staffbeanlist=staffServ.getAllStaffs();
		mav.addObject("StaffList", staffbeanlist);
 		mav.setViewName(ViewRequestConstantService.STAFF_DETAILS_PAGE_REQUEST);
		return mav;
	}
	
	@RequestMapping(value=ActionRequestConstantService.DELETE_STAFF_BY_ID_REQUEST)
	public ModelAndView deleteStaffById(){
		
		int staffId=Integer.parseInt(request.getParameter("staffId"));
		System.out.println("staff controller is called"+request.getParameter("staffId"));
		System.out.println(request.getParameter("staffId"));
		ModelAndView mav=new ModelAndView();
		staffServ.deleteStaff(staffId);
		List<StaffBean> staffbeanlist=staffServ.getAllStaffs();
		mav.addObject("StaffList", staffbeanlist);
 		mav.setViewName(ViewRequestConstantService.STAFF_DETAILS_PAGE_REQUEST);
		/*StaffBean sbean=staffServ.getStaffById(staffId);
	    staffServ.deleteStaff(sbean);
		//mav.addObject("doctorBean", dbean);
		//mav.setViewName("getEditDoctorPage");
*/		return mav;
	}
	 @RequestMapping(value=ActionRequestConstantService.SEARCH_STAFF_BY_NAME_REQUEST)
 	public ModelAndView searchDoctors(){
 		ModelAndView mav=new ModelAndView();
 	System.out.println("search value is"+request.getParameter("searchValue"));	
 	String docName=request.getParameter("searchValue");
 	StaffBean sbean=staffServ.getStaffByName(docName);
 	mav.addObject("staffBean", sbean);	
 	//mav.setViewName("getEditDoctor");
 	mav.setViewName("getSearchStaff");
		return mav;
		}
	 
	

}
