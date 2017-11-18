package com.dotridge.nhc.persistence.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dotridge.nhc.persistence.entity.Hospital;

public class HospitalDaoTest {

	private HospitalDao hospitalDao;

	@Before
	public void setUp() {
		hospitalDao = new HospitalDaoImpl();
	}
	
	@Test
	public void testGetAllHospitals()
	{
		List<Hospital> hospitalsList = hospitalDao.getAllHospitals();
		Assert.assertNotNull("hospitalList is not null",hospitalsList);
	}

	@After
	public void tearDown() {
       hospitalDao=null;
	}
}
