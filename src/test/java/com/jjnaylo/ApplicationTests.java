package com.jjnaylo;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	EmployeeRecord emplRec = new EmployeeRecord();
	
	@Autowired
	private EmployeeRecordRepository service;

	@Before
	public void addTestUserToMongo(){
		service.deleteByLastName("Lewis");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 01, 11, 0, 0, 0);
		Date hireDate = cal.getTime();
		
		emplRec.setFirstName("Bill");
		emplRec.setLastName("Lewis");
		emplRec.setMiddleInitial("D");
		emplRec.setEmailAddress("blewis@gemco.org");
		emplRec.setPhoneNum("555-555-5555");
		emplRec.setPositionCat("Director");
		emplRec.setHireDate(hireDate);
		emplRec.setAddress1("9000 Cobblestone Circle");
		emplRec.setAddress2("");
		emplRec.setCity("Seattle");
		emplRec.setState("WA");
		emplRec.setZip(55555);
		emplRec.setActive(false);
		
		service.insert(emplRec);
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testFindByLastName() {
		String lastName = "Lewis";
		
		String record = service.findByLastName(lastName).get(0).toString();
		
		assertEquals(emplRec.toString(), record);
	}
	
	@Test
	public void testDeleteByLastName() {
		Long deletedSuccess = service.deleteByLastName("Lewis");
		Long deletedFailure = service.deleteByLastName("Bohij");
		
		assertEquals(1.0d, deletedSuccess.doubleValue(), 0);
		assertEquals(0.0d, deletedFailure.doubleValue(), 0);
	}


}
