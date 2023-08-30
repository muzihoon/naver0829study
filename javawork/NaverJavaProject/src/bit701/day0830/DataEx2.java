package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("내 이름은 "+args[0]+" 입니다");
		System.out.println("우리집은 "+args[1]+" 입니다");
		System.out.println("내 혈액형은 "+args[2]+" 형입니다");
		System.out.println();
		System.out.println("실수형 데이터 타입");
		float f1=1234.567891234f;//4바이트 float 으로 값을 지정하려면 f 추가 해야함. 안붙이면 무조건 double로 인식
		double f2=1234.567891234;
		System.out.println(f1);//8자리 까지만 정확하게 출력
		System.out.println(f2);//15자리 까지 정확하게 출력
		
		char ch1='A';
		char ch2='가';
		System.out.println(ch1);
		System.out.println(ch2);
	}

}
