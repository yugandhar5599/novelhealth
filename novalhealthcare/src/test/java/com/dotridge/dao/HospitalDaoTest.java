package com.dotridge.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dotridge.domain.Hospital;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./src/main/resources/applicationContext.xml"})
public class HospitalDaoTest {
	@Autowired
	private HospitalDao hospitalDao;
	
	@Before
	 public void setUp()
	 {
		hospitalDao=new HospitalDaoImpl();
	 
	 }
	@Test
	public void testGetAllHospitals(){
		
		List<Hospital> hospitals = hospitalDao.getAllHospitals();
		Assert.assertNotNull(hospitals);
		Assert.assertEquals(5,hospitals.size());
		
	}
	
	
	@After
	 public void tearDown(){
		hospitalDao=null;
	  
	 }

}
