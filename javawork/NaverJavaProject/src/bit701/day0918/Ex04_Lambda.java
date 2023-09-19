package bit701.day0918;

//자바에서 함수형 프로그램인 람다 표현식은 인터페이스를
//사용하는 익명 내부클래스의 또다른 표현식이다.
//단, 인터페이스는 단 하나의 추상 메서드만 가지고 있어야 한다.

@FunctionalInterface //함수형 할때 붙인다.
interface Orange
{
	public void write();
	//	public void show();//@FunctionalInterface는 메서드가 하나인지 아닌지 검증하는 역할, 오류발생

}

@FunctionalInterface
interface DataAdd
{
	public void add(int x,int y);
}

public class Ex04_Lambda {


	public void absMethod1()
	{

		Orange or=new Orange()
		{
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("안녕하세요 ^^");
			}
		};
		
		or.write();
	}
	
	public void absMethod2()
	{
		Orange or=()->System.out.println("반가워요 ^^");//메서드의 코드가 한줄일경우 {} 생략
		or.write();
		
		//오버라이드 메서드의 코드가 2줄 이상일경우 {} 안에서 주면 된다
		Orange or2=()->{
			System.out.println("람다람다~~");
			System.out.println("여러줄 썻어요!!!");
		};
		
		or2.write();
	}

	public void absMethod3()
	{
//		//람다식으로 오버라이드 해보기
		//기존 방식
//		DataAdd add1= new DataAdd() {
//			@Override
//			public void add(int x, int y) {
//				System.out.println(x+"+"+y+"="+(x+y));
//			}
//		};
		
		DataAdd add1 = (int x1,int y1)->System.out.println(x1+"+"+y1+"="+(x1+y1));
		
		add1.add(100, 200);
		add1.add(5, 7);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_Lambda ex = new Ex04_Lambda();
		ex.absMethod1();
		ex.absMethod2();
		ex.absMethod3();
	}

}
