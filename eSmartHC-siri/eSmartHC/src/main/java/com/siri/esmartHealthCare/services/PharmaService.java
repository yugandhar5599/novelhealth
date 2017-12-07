/**
 * 
 */
package com.siri.esmartHealthCare.services;

import java.util.List;

import com.siri.esmartHealthCare.beans.PharmaBean;

/**
 * @author VENU
 *
 */
public interface PharmaService {
	public PharmaBean addPharma(PharmaBean pharmaBean);
	public PharmaBean updatePharma(PharmaBean pharmaBean);
	public Boolean deletePharma(PharmaBean pharmaBean);
	public Boolean deletePharma(int pharmaId);
	public PharmaBean getPharmaById(int pharmaId);
	public PharmaBean getPharmaByName(String pharmaName);
	public List<PharmaBean> getAllPharmas();
	public List<PharmaBean> searchAllPharmas(int pharmaId,String pharmaName);
}
