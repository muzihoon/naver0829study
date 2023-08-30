package bit701.day0830;

public class OperEx7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 비교연산자와 논리 연산자, 결과 값은 무조건 참(true),거짓(false)
		int kor=100, eng=90, mat=100;
		System.out.println(kor>=80);//true
		System.out.println(kor>=80 || kor!=mat);//true or 연산자는 앞에가 참이면 뒤는 비교 안한다. 
		System.out.println(kor<80 || kor!=mat);//false and 연산자는 앞에가 거짓이면 뒤는 비교 하지 않는다.
		System.out.println(kor>=80 && kor!=mat);//false
		System.out.println(kor<80 && kor!=mat);//false
		System.out.println(!(kor==mat));//false
		System.out.println(kor>=95 && eng>=95 && mat>=95);//false
		System.out.println(kor>=95 && eng>=95 || mat>=95);//false 라고 생각했는데 아님 ture 
		System.out.println(kor>=95 || eng>=95 && mat>=95);//true
		
		int year=2023;
		//위의 년도가 윤년인지 아닌지 알아보자
		System.out.println(year%4==0 && year%100!=0 || year%400==0);
	}

}
