package com.mcgarry.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.hibernate.validator.constraints.Range;

public class MemberDetails {

	// @Range(min = 1, max = 120)
	public int memberNo;
	private String userName;
	// private String password;
	private String name;
	private String surname;
	private String address1;
	private String address2;
	private String town;
	private String postcode;
	private String email;
	private String dob;
	private String telephone;
	private String startDate;
	private String nextRenewalDate;

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		try {
			this.startDate = formatDBDate(startDate);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNextRenewalDate() {
		return nextRenewalDate;
	}

	public void setNextRenewalDate(String nextRenewalDate) {
		try {
			this.nextRenewalDate = formatDBDate(nextRenewalDate);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * public String getPassword() { return password; } public void
	 * setPassword(String password) { this.password = password; }
	 */

	private String formatDBDate(String dbDate) throws Exception {
		if (dbDate != null && !dbDate.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
			String formattedDate;
			Date dateFromDB = sdf.parse(dbDate);
			DateFormat outputFormatter = new SimpleDateFormat("dd MMM yyyy");
			formattedDate = outputFormatter.format(dateFromDB);

			return formattedDate;
		}
		else {
			return "N/A";
		}
	}
}
