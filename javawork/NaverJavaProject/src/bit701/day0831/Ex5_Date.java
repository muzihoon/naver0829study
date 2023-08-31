package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바에서 시간이나 날짜 출력하는 방법
		System.out.println("Date 클래스를 이용해서 시간, 날짜 구하기");
		Date date=new Date();
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day=date.getDate();
		
		int hh=date.getHours();
		int mm=date.getMinutes();
		int ss=date.getSeconds();
		
		System.out.printf("현재 년도 : %d-%2d-%2d\n",year,month,day);
		System.out.printf("현재 년도 : %d-%02d-%02d\n",year,month,day);
		System.out.printf("현재 시간 : %02d:%02d:%02d\n",hh,mm,ss);
		
		System.out.println("Calendar 클래스를 이용해서 시간, 날짜 구하기");
//		Calendar cal=new Calendar();// new로 만들 수 없게 되어있는 클래스. 왜냐면 생성자의  접근 제어자가 protected로 되어있기 때문이다. == public이 아니라 
		// 이런경우에는 getInstance 이런 식으로 무조건 되어있다. api를 보면 static Calendar로 되어있는 이유다.
		Calendar cal=Calendar.getInstance();
	    year=cal.get(Calendar.YEAR);
	    month=cal.get(Calendar.MONTH)+1;
	    day=cal.get(Calendar.DATE);
	    
	    System.out.printf("현재 년도 : %d-%02d-%02d\n",year,month,day);
	    
	    //요일 구하기 
	    int weekint =date.getDay();//0:일, 1:월, ....6:토
	    System.out.println("요일숫자"+weekint);
	    
	    String week=weekint==0?"일":weekint==1?"월":weekint==2?"화":weekint==3?"수":weekint==4?"목":weekint==5?"금":"토";
	    System.out.printf("오늘은 %s요일입니다.",week);
	    
	}

}
