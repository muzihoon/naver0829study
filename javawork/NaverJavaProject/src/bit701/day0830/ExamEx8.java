package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//money 변수에 args[0] 값을 대입후(급여":백만단위:5674321
		/* 
		 * 출력
		 * money : 5674321원
		 * 만원 : 567장
		 * 천원 : 4장
		 * 백원 : 3개
		 * 십원 : 2개
		 * 일원 : 1개
		 *
		 * 
		 *  : 산술연산자를 사용해서 출력해보기
		 *   문자열로 가져오면 계산불가능. Integer로 변경해야한다. 
		 * */
		
		//파라미터에서 월 급여를 읽어서 (문자열) 정수타입으로 변환한다.
		
		//내가 한거
//		int money = Integer.parseInt(args[0]);
//		int a=money/10000;//만원
//		int b=(money%10000)/1000;//천원
//		int c=(money%10000%1000)/100;//백원
//		int d=(money%10000%1000%100)/10;//십원
//		int e=(money%10000%1000%100%10)/1;//일원
//
//		System.out.println("총 금액="+args[0]+"원");
//		System.out.printf("만원=%d장\n",a);
//		System.out.printf("천원=%d장\n",b);
//		System.out.printf("백원=%d개\n",c);
//		System.out.printf("십원=%d개\n",d);
//		System.out.printf("일원=%d개\n",e);
		
		int money = Integer.parseInt(args[0]);
		System.out.println("월 급여 :"+money);
		System.out.println("만원짜리 :"+money/10000+"장");
		System.out.println("천원짜리 :"+(money%10000)/1000+"장");
		System.out.println("백원짜리 :"+(money%1000)/100+"개");
		System.out.println("십원짜리 :"+(money%100)/10+"개");
		System.out.println("일원짜리 :"+(money%10)+"개");
		
	}

}
