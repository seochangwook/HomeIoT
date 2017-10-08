package com.homeiot.application.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
	//현재시간 추출//
	public String getCurrentDate(){
		Calendar cal = Calendar.getInstance();
		String dateString, timeString;
			    
		dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		timeString = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
				
		System.out.println(dateString + " " + timeString);
		String date = dateString + " " + timeString;
		
		return date;
	}
}
