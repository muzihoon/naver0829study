package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char, int 는 같은 타입이라고 봐도 된다.
		char a1=65; //0~255 까지만 가능 char 
		int a2='B';
		// 에러가 안나는 이유, 어차피 아스키 코드로 인식하니까
		System.out.println(a1);//A
		System.out.println(a2);//66
		System.out.println((int)a1);
		System.out.println((char)a2);//66
		
		System.out.printf("%d 의 아스키 문자는 %c 이다\n",(int)a1,a1);
		
		char b1='C';
		int b2=68;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1+2); //묵시적 형변환에 의해서 char+int = int로 나온다. 그러므로 E가 아니라 69가 나온다.
		
		/*
		 * 묵시적 형변환 (자동 형변환, +는 연산을 의미한다) 
		  char +int = int
		  int+int = int
		  long + int = long (더 큰쪽으로 따른다)
		  double + int = double
		  String + int = String
		  String + double = Stirng
		 */
		
		System.out.println((char)(b1+2));//b1+2 = 69 로 int 타입 -> 캐릭터로 강제 형변환해서 출력한다.
		System.out.println(5/2); // int와 int의 연산이므로 무조건 int의 결과로 나옴
		System.out.println(5.0/2);//double+int=double
		System.out.println((double)5/2);//double+int=double
		System.out.println((double)(5/2));//int+int=int 결과를 double로 형변환 해도 2.0이 될뿐이다.
		
		//println 이 대표적인 oberloding (중복)함수다. 왜냐면 여러개의 println이 타입별로 라이브러리에 생성되어 있기 때문이다.
		//println 은 그래서 모든 타입의 출력이 가능하다. 
		
		
		
	}

}
