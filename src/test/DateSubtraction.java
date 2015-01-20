package test;

import java.text.ParseException;
import java.util.Date;

public class DateSubtraction {
	private static final int oneDay = 60*60*1000;//一小時的毫秒數
	public String dateSubtract(Date date1, Date date2){//相差小時數
		long hour=(date2.getTime()-date1.getTime())/(oneDay);
		return String.valueOf(hour);
	}
	public static void main(String[] args) throws ParseException {
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		java.util.Date date1= format.parse("2015-02-01 10:00:00");    
		java.util.Date date2= format.parse("2015-02-01 12:00:00");  
		DateSubtraction date = new DateSubtraction();
		System.out.println(date.dateSubtract(date1, date2));
	}

}
