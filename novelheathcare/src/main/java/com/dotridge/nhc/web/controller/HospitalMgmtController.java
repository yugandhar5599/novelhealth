package com.dotridge.nhc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dotridge.nhc.service.HospitalService;
import com.dotridge.nhc.web.model.HospitalForm;

@Controller
public class HospitalMgmtController {

	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = { "/superAdminHome" })
	public String superAdminHome() {
		return "superAdminHome";
	}

	@RequestMapping(value = { "/hospitalMgmt/addHospitalPage" }, method = RequestMethod.GET)
	public String addHospitalPage(Model model) {
		model.addAttribute("hospitalForm", new HospitalForm());
		return "addHosptialPage";
	}

	@RequestMapping(value = { "/hospitalMgmt/addhospital" })
	public String addHospital(@Valid @ModelAttribute("hospitalForm") HospitalForm hospitalBean, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addHosptialPage";
		}
		HospitalForm insertedHospitalBean = hospitalService.createHospital(hospitalBean);
		if (insertedHospitalBean != null && insertedHospitalBean.getHospitalId() != 0) {
			return "redirect:/hospitalMgmt/getAllHospitals";
		}
		model.addAttribute("insertStatus", "adding of hospital failed!... ");
		return getAllHospitals(model);

	}

	@RequestMapping(value = { "/hospitalMgmt/editHospitalPage" }, method = RequestMethod.GET)
	public String editHospitalPage(@RequestParam("hospId") int hospId, Model model) {
		model.addAttribute("editHospitalForm", hospitalService.getHospitalById(hospId));
		return "editHospitalPage";
	}

	@RequestMapping(value = { "/hospitalMgmt/editHospital" }, method = RequestMethod.POST)
	public String editHospital(@Valid @ModelAttribute("editHospitalForm") HospitalForm hospitalBean, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "editHospitalPage";
		}
		HospitalForm updatedHospitalBean = hospitalService.updateHospital(hospitalBean);
		if (updatedHospitalBean != null && updatedHospitalBean.getHospitalId() != 0) {
			System.out.println("updation sucess");
			return "redirect:/hospitalMgmt/getAllHospitals";
		}
		model.addAttribute("updateStatus", "updating of hospital failed!... ");
		return getAllHospitals(model);

	}

	@RequestMapping(value = { "/hospitalMgmt/getAllHospitals" }, method = RequestMethod.GET)
	public String getAllHospitals(Model model) {
		List<HospitalForm> allHospitals = hospitalService.getAllHospitals();
		model.addAttribute("hospitalList", allHospitals);
		return "hospitalMgmtBoard";
	}

	@RequestMapping(value = { "/hospitalMgmt/statusUpdate" }, method = RequestMethod.GET)
	public String updateHospitalStatus(@RequestParam("hospId") int hospId, Model model) {
		hospitalService.updateHosptialStatus(hospId);
		return getAllHospitals(model);

	}

	@RequestMapping(value = { "/hospitalMgmt/deleteHospital" }, method = RequestMethod.GET)
	public String deleteHospital(@RequestParam("hospId") int hospId, Model model) {

		return (hospitalService.deleteHospital(hospId)) ? getAllHospitals(model) : null;

	}

	@RequestMapping(value = { "/hospitalMgmt/searchHospitals" })
	public String searchHospital(@RequestParam("searchKey") String searchKey, @RequestParam("searchValue") String searchValue, Model model) {
		List<HospitalForm> hospitalList = hospitalService.searchHospital(searchKey, searchValue);
		model.addAttribute("hospitalList", hospitalList);
		return "hospitalMgmtBoard";
	}

	@RequestMapping(value = { "/hospitalMgmt/multipleDelete","/hospitalMgmt/multipleActive","/hospitalMgmt/multipleInActive" }, method = RequestMethod.GET)
	public String multiSelectHospitalActions(HttpServletRequest request, Model model) {
		String viewPage = null;
		if (request.getParameter("action").equalsIgnoreCase("delete")) {
			String[] paramValues = request.getParameterValues("id");
			List<Integer> paramsList = new ArrayList<Integer>(paramValues.length);
			for (int i = 0; i < paramValues.length; i++) {
				paramsList.add(Integer.parseInt(paramValues[i]));
			}
			boolean result = hospitalService.multiSelectHospitalDbOpeations(paramsList);
			if (result) {
				viewPage = getAllHospitals(model);
			} else {
				System.out.println("multiselect db operation failed");
			}

		}
		return viewPage;

	}
}
