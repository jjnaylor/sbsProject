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


}
