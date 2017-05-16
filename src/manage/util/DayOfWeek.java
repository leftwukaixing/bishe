package manage.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayOfWeek {
	
	public String dayOfWeek(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = format.parse(date);
		String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}; 
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(tmpDate);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w]; 
	}
	
	public String timeOfDay(String start){
		String[] timeOfDays = {"第一二节", "第三四节", "第五六节", "第七八节", "第九十节"};
		int i = 0;
		int time = Integer.parseInt(start.split("\\:")[0]);
		switch(time){
		case 10:i = 1;break;
		case 13:i = 2;break;
		case 15:i = 3;break;
		case 18:i = 4;break;
		}
		
		return timeOfDays[i]; 
			
	}
	
//	public static void main(String [] args){
//		DayOfWeek obj = new DayOfWeek();
//		System.out.println(obj.timeOfDay("13:05"));
//	}
	
}
