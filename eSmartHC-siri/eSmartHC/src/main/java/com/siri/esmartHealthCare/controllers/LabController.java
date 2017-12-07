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

import com.siri.esmartHealthCare.beans.LabBean;
import com.siri.esmartHealthCare.constant.ActionRequestConstantService;
import com.siri.esmartHealthCare.constant.ViewRequestConstantService;
import com.siri.esmartHealthCare.services.LabService;

/**
 * @author VENU
 *
 */
@Controller
public class LabController {
	@Autowired
	private LabService labServ;
	@Autowired
	private HttpServletRequest request;
	
	 @RequestMapping(value=ActionRequestConstantService.LAB_DETAILS_REQUEST)
	 	public ModelAndView getEditLabPage(){
	 		ModelAndView mav=new ModelAndView();
			List<LabBean> labBeanList=labServ.getAllLabs();
			mav.addObject("LabList", labBeanList);
	 		mav.setViewName(ViewRequestConstantService.LAB_DETAILS_PAGE_REQUEST);
	 		return mav;
	 		
	 	}
	@RequestMapping(value=ActionRequestConstantService.ADD_LAB_REQUEST)
	public ModelAndView addLab(){
		ModelAndView mav=new ModelAndView();
		LabBean lbean=new LabBean();
		mav.addObject("labBean", lbean);
		mav.setViewName(ViewRequestConstantService.ADD_LAB_PAGE_REQUEST);
		return mav;
	}
	
	@RequestMapping(value=ActionRequestConstantService.SAVE_LAB_DETAILS_REQUEST)
	public ModelAndView saveLab(@ModelAttribute("labBean") LabBean lbean){
		System.out.println("save lab method is called");
		ModelAndView mav=new ModelAndView();
		System.out.println(lbean.getLabName());
		labServ.addLab(lbean);
		List<LabBean> labBeanList=labServ.getAllLabs();
		mav.addObject("LabList", labBeanList);
 		mav.setViewName(ViewRequestConstantService.LAB_DETAILS_PAGE_REQUEST);
		return mav;
	}
	
	@RequestMapping(value=ActionRequestConstantService.LAB_BY_ID_REQUEST)
	public ModelAndView editDoctorpage(){
		int labId=Integer.parseInt(request.getParameter("labId"));
		System.out.println(request.getParameter("labId"));
		ModelAndView mav=new ModelAndView();
		LabBean lbean=labServ.getLabById(labId);
		mav.addObject("labBean", lbean);
		//mav.setViewName(ViewRequestConstantService.EDIT_LAB_PAGE_REQUEST);
		mav.setViewName("views/editLab");
		return mav;
	}
	@RequestMapping(value=ActionRequestConstantService.UPDATE_LAB_REQUEST)
	public ModelAndView updateLab(@ModelAttribute("labBean") LabBean labBean){
		ModelAndView mav=new ModelAndView();
		System.out.println("docid is"+labBean.getLabId());
		LabBean lbean=labServ.updateLab(labBean);
		List<LabBean> labBeanList=labServ.getAllLabs();
		mav.addObject("LabList", labBeanList);
 		mav.setViewName(ViewRequestConstantService.LAB_DETAILS_PAGE_REQUEST);
		return mav;
	}
	@RequestMapping(value=ActionRequestConstantService.DELETE_LAB_BY_ID_REQUEST)
	public ModelAndView deleteLabById(){
		int labId=Integer.parseInt(request.getParameter("labId"));
		System.out.println(request.getParameter("labId"));
		ModelAndView mav=new ModelAndView();
		labServ.deleteLab(labId);
		List<LabBean> labBeanList=labServ.getAllLabs();
		mav.addObject("LabList", labBeanList);
 		mav.setViewName(ViewRequestConstantService.LAB_DETAILS_PAGE_REQUEST);
		/*LabBean lbean=labServ.getLabById(labId);
	    labServ.deleteLab(lbean);
		//mav.addObject("doctorBean", dbean);
		//mav.setViewName("getEditDoctorPage");
*/
		return mav;
	}
	 @RequestMapping(value=ActionRequestConstantService.SEARCH_LAB_BY_NAME_REQUEST)
 	public ModelAndView searchLabs(){
 		ModelAndView mav=new ModelAndView();
 	System.out.println(request.getParameter("searchValue"));	
 	String labName=request.getParameter("searchValue");
 	LabBean labbean=labServ.getLabByName(labName);
 	mav.addObject("labBean", labbean);	
 	//mav.setViewName("getEditDoctor");
 	mav.setViewName(ViewRequestConstantService.LAB_DETAILS_PAGE_REQUEST);
		return mav;
		}
	


}
