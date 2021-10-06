package com.jakehcodes.todo.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	public Date formatDate(String date) {
		
		Date formattedDate = null;
		try {
			formattedDate = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}

}