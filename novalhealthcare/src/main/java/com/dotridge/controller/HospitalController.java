package com.dotridge.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dotridge.bean.HospitalBean;
import com.dotridge.service.HospitalService;
import com.dotridge.util.ServiceConstance;

@Controller
@RequestMapping("/hospitalMgmt")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = "/getAllHospitals")
	public ModelAndView viewAllHospitals() {
		try {
			List<HospitalBean> uihosplist = hospitalService.getAllHospital();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getHospitalBoard");
			System.out.println("list of hospitals" + uihosplist);
			/*
			 * int listSize=uihosplist.size(); int
			 * pagePerSize=(listSize/ServiceConstance.NUBER_OF_REC_PER_PAGE)+1;
			 * int pageSize= (int)
			 * Math.round(Double.valueOf(String.valueOf(pagePerSize))); List
			 * pageBarSize=new ArrayList(); for(int i=0;i<pageSize;i++){
			 * pageBarSize.add(i); }
			 * 
			 * System.out.println("page bar size"+pageBarSize.size());
			 * mav.addObject("pagePerSize",pageBarSize);
			 */
			mav.addObject("uihosplist", uihosplist);
			return mav;
		} catch (Exception e) {

		}
		return null;
	}

	@RequestMapping("/getAllHospitalsByPaging")
	public String getAllHospitalsByPaging(HttpServletRequest request, Model model) {
		String cuurentPage = request.getParameter("currentPage");
		int cPage = Integer.valueOf(cuurentPage);
		int noOfReocrdsPages = ServiceConstance.NUBER_OF_REC_PER_PAGE;
		List<HospitalBean> uihosplist = hospitalService.getAllHospitalsByPaging(cPage, noOfReocrdsPages);
		model.addAttribute("uihosplist", uihosplist);

		List<HospitalBean> hosplist = hospitalService.getAllHospital();
		System.out.println("list of hospitals" + hosplist.size());
		int listSize = hosplist.size();
		int pagePerSize = (listSize / ServiceConstance.NUBER_OF_REC_PER_PAGE) + 1;
		int pageSize = (int) Math.round(Double.valueOf(String.valueOf(pagePerSize)));
		List pageBarSize = new ArrayList();
		for (int i = 0; i < pageSize; i++) {
			pageBarSize.add(i);
		}

		System.out.println("page bar size" + pageBarSize.size());
		model.addAttribute("pagePerSize", pageBarSize);

		return "getHospitalBoard";
	}

	@RequestMapping("/getHospitalRegForm")
	public String getHospitalRegForm(Model model) {
		HospitalBean hospBean = new HospitalBean();
		model.addAttribute("hospBean", hospBean);
		return "addHospitalFormDef";
	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
	public ModelAndView addHospital(@ModelAttribute("hospBean") HospitalBean hospBean) {
		// System.out.println(hospBean.toString());
		hospitalService.addHospital(hospBean);
		try {
			List<HospitalBean> uihosplist = hospitalService.getAllHospital();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getHospitalBoard");
			System.out.println("list of hospitals" + uihosplist.size());
			mav.addObject("uihosplist", uihosplist);
			return mav;
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping("/editHospital")
	public String editHospital(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");

		System.out.println("Hospital Id..\t" + hospId);
		HospitalBean hospBean = hospitalService.getHospitalById(Integer.valueOf(hospId));
		System.out.println("HospitalBean..\t" + hospBean.toString());
		model.addAttribute("hospBean", hospBean);
		return "editHospitalDef";
	}

	@RequestMapping("/deleteHospital")
	public String deleteHospital(HttpServletRequest request, Model model) {
		String hospId = request.getParameter("hospId");

		System.out.println("Hospital delete Id..\t" + hospId);
		hospitalService.deleteHospital(Integer.valueOf(hospId));

		return "redirect:getAllHospitals";
	}

	@RequestMapping(value = "/updateHospital")
	public ModelAndView updateHospital(@ModelAttribute("hospBean") HospitalBean hospBean) {

		System.out.println("hospBean in controller is:\t" + hospBean.toString());
		hospitalService.updateHospital(hospBean);
		try {
			List<HospitalBean> uihosplist = hospitalService.getAllHospital();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("getHospitalBoard");
			System.out.println("list of hospitals" + uihosplist.size());

			mav.addObject("uihosplist", uihosplist);
			return mav;
		} catch (Exception e) {

		}
		return null;
	}

	@RequestMapping("/searchHospital")
	public String searchHospital(HttpServletRequest req, Model model) {

		String searchKey = req.getParameter("searchKey");
		String searchValue = req.getParameter("searchValue");

		System.out.println(searchKey + " " + searchValue);

		if ((searchKey != null && !searchKey.isEmpty()) && (searchValue != null && !searchValue.isEmpty())) {
			if (searchKey.equalsIgnoreCase("hospitalName")) {
				List<HospitalBean> hosplist = hospitalService.getHospitalByName(searchValue);
				model.addAttribute("uihosplist", hosplist);
				return "getHospitalBoard";
			}
			if (searchKey.equalsIgnoreCase("email")) {
				List<HospitalBean> hosplist = hospitalService.getHospitalByEmail(searchValue);
				model.addAttribute("uihosplist", hosplist);
				return "getHospitalBoard";
			}
		}

		return null;
	}

}
