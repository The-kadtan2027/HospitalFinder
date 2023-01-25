package com.gk.dto;

public class Hospital {
	private String hospitalCode;
	private String hospitalName;
	private String contactPerson;
	private String contactNumber;
	private String address;
	
	public Hospital(String hospitalCode ,String hospitalName ,String contactPerson,String contactNumber,String address) {
		this.hospitalCode = hospitalCode;
		this.hospitalName = hospitalName;
		this.contactPerson = contactPerson;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
