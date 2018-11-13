package com.emember.model;

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
	private String forename;
	private String surname;
	private String address_1;
	private String address_2;
	private String town;
	private String postcode;
	private String email;
	private String dob;
	private String dobYear;
	private String dobMonth;
	private String dobDay;
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

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
		/*this.dob = this.getDobDay() + "/" + this.getDobMonth() + "/" + this.getDobYear();
		try {
			this.dob = formatDateToDB(dob);
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dob;*/
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getDobYear() {
		return dobYear;
	}

	public void setDobYear(String dobYear) {
		this.dobYear = dobYear;
	}

	public String getDobMonth() {
		return dobMonth;
	}

	public void setDobMonth(String dobMonth) {
		this.dobMonth = dobMonth;
	}

	public String getDobDay() {
		return dobDay;
	}

	public void setDobDay(String dobDay) {
		this.dobDay = dobDay;
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
		/*try {
			this.startDate = formatDateFromDB(startDate);
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		this.startDate = startDate;
	}

	public String getNextRenewalDate() {
		return nextRenewalDate;
	}

	public void setNextRenewalDate(String nextRenewalDate) {
		/*try {
			this.nextRenewalDate = formatDateFromDB(nextRenewalDate);
		} catch (ParseException pe) {
			pe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		this.nextRenewalDate = nextRenewalDate;
	}
	/*
	 * public String getPassword() { return password; } public void
	 * setPassword(String password) { this.password = password; }
	 */

	private String formatDateFromDB(String dbDate) throws Exception {
		if (dbDate != null && !dbDate.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate;
			Date dateFromDB = sdf.parse(dbDate);
			DateFormat outputFormatter = new SimpleDateFormat("dd MMM yyyy");
			formattedDate = outputFormatter.format(dateFromDB);

			return formattedDate;
		} else {
			return "N/A";
		}
	}
	private String formatDateToDB(String dobDate) throws Exception {
		if (dobDate != null && !dobDate.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			String formattedDate;
			Date dateFromDB = sdf.parse(dobDate);
			DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = outputFormatter.format(dateFromDB);

			return formattedDate;
		} else {
			return "N/A";
		}
	}
}
