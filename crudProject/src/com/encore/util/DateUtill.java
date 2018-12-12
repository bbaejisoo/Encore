package com.encore.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtill {

	//날짜 바꾸는 함수를 여기서 생성
		public static Date stringToDate(String dt) {
			//String => java.util.Date => java.sql.Date
			Date d2 = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date d1 = sdf.parse(dt);
				d2 = new Date(d1.getTime());
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d2;
		}
	
	
}
