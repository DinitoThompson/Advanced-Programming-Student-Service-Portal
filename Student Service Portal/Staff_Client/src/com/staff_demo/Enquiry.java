package com.staff_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

import java.awt.HeadlessException;

public class Enquiry {
	int e_id;
	String e_state;
	String E_nature;
	String enquiry_complaint;
	String enquiry_detail;
	String enquiry_response_date;
	String enquiry_response;

	public Enquiry(String enquiry_response, String enquiry_response_date) {
		this.enquiry_response = enquiry_response;
		this.enquiry_response_date = enquiry_response_date;
	}

	public String getEnquiry_response_date() {
		return enquiry_response_date;
	}

	public void setEnquiry_response_date(String enquiry_response_date) {
		this.enquiry_response_date = enquiry_response_date;
	}

	public String getEnquiry_response() {
		return enquiry_response;
	}

	public void setEnquiry_response(String enquiry_response) {
		this.enquiry_response = enquiry_response;
	}

	public Enquiry(int e_id, String e_state, String e_nature) throws HeadlessException {
		this.e_id = e_id;
		this.e_state = e_state;
		E_nature = e_nature;
	}

	public Enquiry(String enquiry_nature, String enquiry_complaint, String enquiry_detail) {

		this.E_nature = enquiry_nature;
		this.enquiry_complaint = enquiry_complaint;
		this.enquiry_detail = enquiry_detail;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_state() {
		return e_state;
	}

	public void setE_state(String e_state) {
		this.e_state = e_state;
	}

	public String getE_nature() {
		return E_nature;
	}

	public void setE_nature(String e_nature) {
		E_nature = e_nature;
	}

	public String getEnquiry_complaint() {
		return enquiry_complaint;
	}

	public void setEnquiry_complaint(String enquiry_complaint) {
		this.enquiry_complaint = enquiry_complaint;
	}

	public String getEnquiry_detail() {
		return enquiry_detail;
	}

	public void setEnquiry_detail(String enquiry_detail) {
		this.enquiry_detail = enquiry_detail;
	}
}
