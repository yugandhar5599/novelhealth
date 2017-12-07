/**
 * 
 */
package com.siri.esmartHealthCare.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.siri.esmartHealthCare.beans.MedicinesBean;
import com.siri.esmartHealthCare.beans.PharmaBean;
import com.siri.esmartHealthCare.beans.RequiredMedicinesBean;
import com.siri.esmartHealthCare.constant.ActionRequestConstantService;
import com.siri.esmartHealthCare.constant.ViewRequestConstantService;
import com.siri.esmartHealthCare.services.MedicinesService;
import com.siri.esmartHealthCare.services.PharmaService;
import com.siri.esmartHealthCare.services.RequiredMedicinesService;

/**
 * @author VENU
 *
 */
@Controller
public class PharmaController {
	@Autowired
	private PharmaService pharmaser;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private RequiredMedicinesService rmediser;
	@Autowired
	private MedicinesService mediser;
	Logger logger = Logger.getLogger(PharmaController.class);

	//logger.debug("PharmaController is called debug");
	//logger.info("doGet is called in AutherizationController info");
	
	 @RequestMapping(value=ActionRequestConstantService.PHARMA_DETAILS_REQUEST)
	  	public ModelAndView getEditPharmaPage(){
		 logger.debug("PharmaController is called debug");
	  		ModelAndView mav=new ModelAndView();
	  		List<PharmaBean> pharmabeanlist=pharmaser.getAllPharmas();
			mav.addObject("PharmaList", pharmabeanlist);
			mav.setViewName(ViewRequestConstantService.PHARMA_DETAILS_PAGE_REQUEST);
			return mav;
	 		}
	 
	 @RequestMapping(value=ActionRequestConstantService.ADD_PHARMA_REQUEST)
		public ModelAndView addPharma(){
		 logger.info("doGet is called in AutherizationController info");
			ModelAndView mav=new ModelAndView();
			PharmaBean pbean=new PharmaBean();
			mav.addObject("pharmaBean", pbean);
			mav.setViewName(ViewRequestConstantService.ADD_PHARMA_PAGE_REQUEST);
			return mav;
		}
		
		@RequestMapping(value=ActionRequestConstantService.SAVE_PHARMA_DETAILS_REQUEST)
		public ModelAndView savePharma(@ModelAttribute("pharmaBean") PharmaBean pbean){
			System.out.println("save Pharma method is called");
			ModelAndView mav=new ModelAndView();
			System.out.println(pbean.getPharmaName());
			pharmaser.addPharma(pbean);
			List<PharmaBean> pharmabeanlist=pharmaser.getAllPharmas();
			mav.addObject("PharmaList", pharmabeanlist);
			mav.setViewName(ViewRequestConstantService.PHARMA_DETAILS_PAGE_REQUEST);
			return mav;
		}
		
		@RequestMapping(value=ActionRequestConstantService.PHARMA_BY_ID_REQUEST)
		public ModelAndView editDoctorpage(){
			int docId=Integer.parseInt(request.getParameter("pharmaId"));
			System.out.println(request.getParameter("pharmaId"));
			ModelAndView mav=new ModelAndView();
			PharmaBean pbean=pharmaser.getPharmaById(docId);
			mav.addObject("pharmaBean", pbean);
			mav.setViewName(ViewRequestConstantService.EDIT_PHARMA_PAGE_REQUEST);
			return mav;
		}
		@RequestMapping(value=ActionRequestConstantService.UPDATE_PHARMA_REQUEST)
		public ModelAndView updatePharma(@ModelAttribute("pharmaBean") PharmaBean pharmaBean){
			ModelAndView mav=new ModelAndView();
			System.out.println("pharmaid is"+pharmaBean.getPharmaId());
			PharmaBean pbean=pharmaser.updatePharma(pharmaBean);
			if(pbean.getPharmaId()>0){
				getEditPharmaPage();
			}
			List<PharmaBean> pharmabeanlist=pharmaser.getAllPharmas();
			mav.addObject("PharmaList", pharmabeanlist);
			mav.setViewName(ViewRequestConstantService.PHARMA_DETAILS_PAGE_REQUEST);
			return mav;
		}
		@RequestMapping(value=ActionRequestConstantService.DELETE_PHARMA_BY_ID_REQUEST)
		public ModelAndView deletePharmaById(){
			int pharmaId=Integer.parseInt(request.getParameter("pharmaId"));
			System.out.println(request.getParameter("pharmaId"));
			ModelAndView mav=new ModelAndView();
			pharmaser.deletePharma(pharmaId);
			List<PharmaBean> pharmabeanlist=pharmaser.getAllPharmas();
			mav.addObject("PharmaList", pharmabeanlist);
			mav.setViewName(ViewRequestConstantService.PHARMA_DETAILS_PAGE_REQUEST);
			/*PharmaBean pbean=pharmaser.getPharmaById(pharmaId);
		    pharmaser.deletePharma(pbean);
			//mav.addObject("doctorBean", dbean);
			//mav.setViewName("getEditDoctorPage");
*/			return mav;
		}
		 @RequestMapping(value=ActionRequestConstantService.SEARCH_PHARMA_BY_NAME_REQUEST)
	 	public ModelAndView searchPharmas(){
	 		ModelAndView mav=new ModelAndView();
	 	System.out.println(request.getParameter("searchValue"));	
	 	String pharmaName=request.getParameter("searchValue");
	 	PharmaBean pharmabean=pharmaser.getPharmaByName(pharmaName);
	 	mav.addObject("pharmaBean", pharmabean);	
	 	//mav.setViewName("getEditDoctor");
	 	mav.setViewName(ViewRequestConstantService.PHARMA_DETAILS_PAGE_REQUEST);
			return mav;
			}
		 @RequestMapping(value="/getAllAvailabelMedicinesPage")
		 	public ModelAndView getPharmaPage(){
			 System.out.println("---------------->");
			 logger.debug("PharmaController is called debug...");
			 logger.info("fdjifsdfkdkof");
		 		ModelAndView mav=new ModelAndView();
		 		List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
				for(MedicinesBean medibean:medicinebeanlist){
					System.out.println(medibean.getMedicineId());
					System.out.println(medibean.getMedicineName());
					System.out.println(medibean.getManifactureDate());
					System.out.println(medibean.getExpiredDate());
				}
				mav.addObject("MedicinesList", medicinebeanlist);
				List<String> searchItem=new ArrayList<String>();
				searchItem.add("searchByName");
				searchItem.add("searchByDate");
				mav.addObject("searchItem", searchItem);
				mav.setViewName("getMedicines");
				return mav;
				}
		 @RequestMapping(value="/addMedicines")
		 public ModelAndView addMedicines(){
			 ModelAndView mav=new ModelAndView();
			 MedicinesBean mbean=new MedicinesBean();
			 mav.addObject("medBean", mbean);
			 mav.setViewName("getaddMedicinesPage");
			 return mav;
	 
		 }
		 
		 @RequestMapping(value="/saveMedicines")
		 public ModelAndView saveMedicines(@ModelAttribute("medBean") MedicinesBean medicinesBean){
			ModelAndView mav=new ModelAndView();
			mediser.addMedicines(medicinesBean) ;
			List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
			mav.addObject("MedicinesList", medicinebeanlist);
			mav.setViewName("getMedicines");
			 return mav;
		 }
		 
		 @RequestMapping(value="/getAllMediciensById")
		 public ModelAndView editMedicines(@RequestParam("medicineId") String mId){
			 
			 int medicineId1=Integer.parseInt(mId);
			 System.out.println(medicineId1);
			 ModelAndView mav=new ModelAndView();
			 MedicinesBean mbean=mediser.getMedicinesById(medicineId1);
			 mav.addObject("medBean", mbean);
			 mav.setViewName("geteditMedicinesPage");
			 return mav;
	 
		 }
		 
		 @RequestMapping(value="/updateMediciens",method=RequestMethod.POST)
		 public ModelAndView updateMedicines(@ModelAttribute("medBean") MedicinesBean medicinesBean){
			 ModelAndView mav=new ModelAndView();
			 mediser.updateMedicines(medicinesBean);
			 List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
			 mav.addObject("MedicinesList", medicinebeanlist);
			 mav.setViewName("getMedicines");
			 return mav;
	 
		 }
		 @RequestMapping(value="/deleteMedicineById")
		 public ModelAndView deleteMedicines(@RequestParam("medicineId") String mId){
			 int medicineId1=Integer.valueOf(mId);
			 ModelAndView mav=new ModelAndView();
			 MedicinesBean mbean=mediser.getMedicinesById(medicineId1);
			 mediser.deleteMedicines(mbean);
			 List<MedicinesBean> medicinebeanlist=mediser.getAllMedicines();
			 mav.addObject("MedicinesList", medicinebeanlist);
			 mav.setViewName("getMedicines");
			 return mav;
	 
		 }
		 
		 
		 
		 @RequestMapping(value="/searchMedicines")
		 public ModelAndView searchMedicine(){
			 System.out.println("search medicines called");
			String searchvalue= request.getParameter("searchValue");
			String searchCriteria=request.getParameter("searchCriteria");
			ModelAndView mav=new ModelAndView();
			if(searchCriteria.equals("name")){
				MedicinesBean mbean=mediser.getMedicinesByName(searchvalue);
				mav.addObject("mbean", mbean);
				mav.setViewName("getMedicines");
				System.out.println(mbean.getExpiredDate());
			}else{
				//System.out.println("");
				List<MedicinesBean> mbeanList=mediser.getMedicinesByDate(searchvalue);
				mav.addObject("MedicinesList", mbeanList);
				mav.setViewName("getMedicines");
				//System.out.println(mbean.getMedicineName());
			}		
			return mav;
		 }
		 @RequestMapping(value="getAllRequiredMedicinesPage")
		 public ModelAndView requiredMedicinesPage(){
			 List<RequiredMedicinesBean> rmbean=rmediser.getAllRequiredMedicines();
			ModelAndView mav=new ModelAndView();
			mav.addObject("requiredMedicinesBean", rmbean);	
			mav.setViewName("getRequiredMedicines");
			return mav;
		 }

}


