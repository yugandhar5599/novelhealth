/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.MedicinesBean;

/**
 * @author VENU
 *
 */
public interface MedicinesService {
	public MedicinesBean addMedicines(MedicinesBean medicinesBean);
	public MedicinesBean updateMedicines(MedicinesBean medicinesBean);
	public Boolean deleteMedicines(MedicinesBean medicinesBean);
	public MedicinesBean getMedicinesByName(String medicineName);
	public List<MedicinesBean> getMedicinesByDate(String medicineName);
	public MedicinesBean getMedicinesById(int medicineId);
	public List<MedicinesBean> getAllMedicines();
	public List<MedicinesBean> searchAllMedicines(int medicineId,String medicineName);

}
