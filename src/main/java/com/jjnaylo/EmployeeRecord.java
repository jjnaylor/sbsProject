package com.jjnaylo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employeeRecord")

public class EmployeeRecord {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String emailAddress;
	private String phoneNum;
	private String positionCat;
	private Date hireDate;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zip;
	private boolean active;
	
	public EmployeeRecord() {
		
	}
	
	public EmployeeRecord(String firstName, String lastName, String middleInitial, String emailAddress, String phoneNum,
				   String positionCat, Date hireDate, String address1, String address2, String city, String state,
				   int zip, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.emailAddress = emailAddress;
		this.phoneNum = phoneNum;
		this.positionCat = positionCat;
		this.hireDate = hireDate;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.active = active;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleInitial() {
		return middleInitial;
	}
	
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getPositionCat() {
		return upperCaseFirstLetter(positionCat);
	}
	
	public void setPositionCat(String positionCat) {
		this.positionCat = positionCat;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getFullAddress() {
		String address = address1 + "\n" + address2;
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state.toUpperCase();
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String upperCaseFirstLetter(String stringToUpper) {
		stringToUpper = stringToUpper.substring(0, 1).toUpperCase() + stringToUpper.substring(1);
		return stringToUpper;
	}
	
	@Override
	public String toString() {
		return "Employee record: {\n"
				+ "  First Name: " + firstName +",\n"
				+ "  Last Name: " + lastName + ",\n"
				+ "  Middle Initial: " + middleInitial + ",\n"
				+ "  Email: " + emailAddress + ",\n"
				+ "  Phone: " + phoneNum + ",\n"
				+ "  Position: " + positionCat + ",\n"
				+ "  Date Hired: " + hireDate + ",\n"
				+ "  Address 1: " + address1 + ",\n"
				+ "  Address 2: " + address2 + ",\n"
				+ "  City: " + city + ",\n"
				+ "  State: " + state + ",\n"
				+ "  Zip: " + zip + ",\n"
				+ "  Active: " + active + "\n"
				+ "}";
	}
}
