/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.RequiredMedicines;

/**
 * @author VENU
 *
 */
public interface RequiredMedicinesDao {
	public RequiredMedicines addRequiredMedicines(RequiredMedicines requiredMedicines);
	public RequiredMedicines updateRequiredMedicines(RequiredMedicines requiredMedicines);
	public Boolean deleteRequiredMedicines(RequiredMedicines requiredMedicines);
	public RequiredMedicines getRequiredMedicinesByName(String medicinesName);
	public List<RequiredMedicines> getRequiredMedicinesByDate(String medicinesName);
	public RequiredMedicines getRequiredMedicinesById(int medicinesId);
	public List<RequiredMedicines> getAllRequiredMedicines();
	public List<RequiredMedicines> searchAllRequiredMedicines(int medicinesId,String medicinesName);
}
