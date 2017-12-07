/**
 * 
 */
package com.siri.esmartHealthCare.dao;

import java.util.List;

import com.siri.esmartHealthCare.domain.Doctor;
import com.siri.esmartHealthCare.domain.Pharma;

/**
 * @author VENU
 *
 */
public interface PharmaDao {
	public Pharma addPharma(Pharma pharma);
	public Pharma updatePharma(Pharma pharma);
	public Boolean deletePharma(Pharma pharma);
	public Boolean deletePharma(int pharmaId);
	public Pharma getPharmaByName(String pharmaName);
	public Pharma getPharmaById(int pharmaId);
	public List<Pharma> getAllPharmas();
	public List<Pharma> searchAllPharmas(int pharmaId,String pharmaName);

}
