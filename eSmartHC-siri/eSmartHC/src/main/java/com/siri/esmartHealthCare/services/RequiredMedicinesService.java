/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.RequiredMedicinesBean;

/**
 * @author VENU
 *
 */
public interface RequiredMedicinesService {
	public RequiredMedicinesBean addRequiredMedicines(RequiredMedicinesBean reqmedicinesBean);
	public RequiredMedicinesBean updateRequiredMedicines(RequiredMedicinesBean reqmedicinesBean);
	public Boolean deleteRequiredMedicines(RequiredMedicinesBean reqmedicinesBean);
	public RequiredMedicinesBean getRequiredMedicinesByName(String medicinesName);
	public List<RequiredMedicinesBean> getRequiredMedicinesByDate(String medicinesName);
	public RequiredMedicinesBean getRequiredMedicinesById(int medicinesId);
	public List<RequiredMedicinesBean> getAllRequiredMedicines();
	public List<RequiredMedicinesBean> searchAllRequiredMedicines(int medicinesId,String medicinesName);
}
