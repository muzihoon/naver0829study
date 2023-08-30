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
		// a =args[0]/10000 =567
		// b =(args[0]%10000)/1000 =4 
		// c =(args[0]%10000%1000)/100=3
		// d =(args[0]%10000%1000%100)/10=2
		// e =(args[0]%10000%1000%100%10)/1=1
		
		int total = Integer.parseInt(args[0]);
		int a=total/10000;//만원
		int b=(total%10000)/1000;//천원
		int c=(total%10000%1000)/100;//백원
		int d=(total%10000%1000%100)/10;//십원
		int e=(total%10000%1000%100%10)/1;//일원

		System.out.println("총 금액="+args[0]+"원");
		System.out.printf("만원=%d장\n",a);
		System.out.printf("천원=%d장\n",b);
		System.out.printf("백원=%d개\n",c);
		System.out.printf("십원=%d개\n",d);
		System.out.printf("일원=%d개\n",e);
	}

}
