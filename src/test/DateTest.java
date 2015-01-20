package test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	private Date addDays(Date date, int num){//增加日期
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, num);
	    return calendar.getTime();
	} 
	
	public static void main(String[] args){
		DateTest date = new DateTest();
		System.out.println(date.addDays(new Date(), 12));
	}
}
