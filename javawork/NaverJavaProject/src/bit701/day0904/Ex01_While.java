package bit701.day0904;

public class Ex01_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 반복문에는 for, while, do-while 3가지가 있다.
		 * for문은 주로 반복횟수가 정해져 있는 경우에 많이 사용
		 * while 이나 do-while 은 반복횟수가 정해져 있지 않은 경우에 많이 사용
		 * while 과 do-while 차이점은 조건을 먼저 주느냐, 나중에 주느냐(선조건,후조건) 차이 
		 * 
		 * */
		
		int a=65; // 대문자 A의 아스키코드 값
		while(a<=90)// 조건이 참인동안 실행 : 91이 되면 빠져나간다.
		{
//			System.out.println((char)a); // 65를 char로 형변환 한다. 
//			a++;
			//위 코드를 한줄로 줄여보세요.
			System.out.print((char)a++);
		} 
		System.out.println();
		System.out.println("빠져나온 후의 a값"+ a);
		
		
		
		
		a=65;
		while(true) 
		{
			System.out.print((char)a++);
			if(a>90) { //a가 90보다 커지면 빠져나감
				break;
			}
			
		}//while2 끝
		
		System.out.println();
		
		
		a=65;
		do {
			System.out.print((char)a++);
		}while(a<=90); //조건뒤에 반드시 ; 추가
		
		int n=10;
		// while과 do-while의 차이
//		while(n<10)// 조건이 거짓이면 한번도 반복실행을 안한다.
//		{
//			System.out.println(n--);
//		}
		
		// do while은 무조건 일단 한번은 실행
		do {
			System.out.println(n--);
		}while(n<10);
	}//메인 끝

}//클래스 끝
