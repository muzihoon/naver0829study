package bit701.day0905;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Ex02_JuminNo_My {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 12일때는 1900 34일때는 2000을 더해라 
		// 135 남성 246 여성 
		// substring  

		// while 문으로 작성한다.
		// 주민번호를 입력한다.
		// 실행결과로 
		// 주민번호 : 970303-2222123
		// 97년 03월 03일생
		// 내국인
		// 여성  
		// q & Q 일 경우 종료 "프로그램을 종료합니다" 출력

		//입력 
		Scanner sc = new Scanner(System.in);

		//내국인 외국인 구분 
		Exit:
			while(true) {
				System.out.println();
				System.out.print("=".repeat(25));
				System.out.println();
				System.out.println("주민번호를 입력하세요. (프로그램 종료 q)");
				String num = sc.nextLine();

				//프로그램을 종료한다.
				if(num.equalsIgnoreCase("q"))
				{
					System.out.println();
					System.out.println("프로그램을 종료합니다.");
					return;

				}

				System.out.println("주민번호:"+num);



				String year =num.substring(0,2); // 년도
				String month =num.substring(2,4); // 월
				String day =num.substring(4,6); // 일
				char sex = num.charAt(7);
				//substring 
				System.out.printf("%s년 %s월 %s일생\n",year,month,day);


				//정규식 사용
				// 주민등록번호 형식을 검증하는 정규 표현식
				String regex = "^[0-9]{6}-[0-9]{7}$"; // 6자리 숫자 - 7자리 숫자

				if (Pattern.matches(regex, num)) {
					switch (sex)
					{		
					//남성
					case '1' ,'3': 
						System.out.println("내국인");
					System.out.println("남성");
					break ;
					case '5' :
						System.out.println("외국인");
						System.out.println("남성");
						break ;

						//여성
					case '2' ,'4': 
						System.out.println("내국인");
					System.out.println("여성");
					break ;
					case '6' :
						System.out.println("외국인");
						System.out.println("여성");
						break ;

					}//스위치 끝

				} else {
					System.out.println("잘못된 주민등록번호 형식입니다.");

				}//else 끝 
			}//와일끝
	}
}
