package com.emember.repository.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DBDateFormatter {
	
	public String formatDateToDB(String dbDate)  {
		String formattedDate="";
		System.out.println("JM formatDateToDB");
		if (dbDate != null && !dbDate.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");	
			Date dateFromDB;
			try {
				dateFromDB = sdf.parse(dbDate);
				DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
				formattedDate = outputFormatter.format(dateFromDB);
				return formattedDate;			
			} catch (ParseException e) {
				e.printStackTrace();
			}
						
		} else {
			formattedDate = "N/A";
		}
		return formattedDate;	
	}
	
	public String formatDateFromDB(String dbDate) {
		String formattedDate="";
		System.out.println("JM1 formatDateFromDB");
		if (dbDate != null && !dbDate.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateFromDB;
			try {
				dateFromDB = sdf.parse(dbDate);
				DateFormat outputFormatter = new SimpleDateFormat("dd MMM yyyy");
				formattedDate = outputFormatter.format(dateFromDB);
				return formattedDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		} else {
			formattedDate = "N/A";
		}
		return formattedDate;
	}
}
