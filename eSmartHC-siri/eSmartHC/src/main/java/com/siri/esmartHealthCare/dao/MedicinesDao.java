/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.Date;
import java.util.List;

import com.siri.esmartHealthCare.domain.Medicines;

/**
 * @author VENU
 *
 */
public interface MedicinesDao {
	public Medicines addMedicines(Medicines medicine);
	public Medicines updateMedicines(Medicines medicine);
	public Boolean deleteMedicines(Medicines medicine);
	public Medicines getMedicinesByName(String medicineName);
	public List<Medicines> getMedicinesByDate(Date date);
	public Medicines getMedicinesById(int medicineId);
	public List<Medicines> getAllMedicines();
	public List<Medicines> searchAllMedicines(int medicineId,String medicineName);

}
