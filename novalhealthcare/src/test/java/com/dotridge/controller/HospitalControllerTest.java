package com.dotridge.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./src/main/resources/applicationContext.xml","classpath:novalhealth-servlet.xml"})
public class HospitalControllerTest {
	@Autowired
	private HospitalController hospitalController;
	@Autowired
	WebApplicationContext context;
	Model model;
	@Before
	public void setUp(){
		model=new BindingAwareModelMap();
	}
	@Test
	public void testgetAllHospitals(){
		String viewAllHospital = hospitalController.viewAllHospital(model);
		Assert.assertNotNull(viewAllHospital);
		Assert.assertEquals("getHospitalBoard", viewAllHospital);
	}
	
}
