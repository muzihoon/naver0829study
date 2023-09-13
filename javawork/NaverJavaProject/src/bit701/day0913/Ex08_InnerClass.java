package bit701.day0913;

class OuterA
{
	int a=10;
	static int b=20;

	// Member 내부 클래스
	class InnerA
	{
		int c=30;
		static int d=40;//jdk 11버전까지는 오류 발생, 멤버 내부클래스에서 static 선언 불가능. jdk17에서는 가능.

		public void showInner()
		{
			System.out.println("** 내부 클래스의 메서드 **");
			System.out.println("외부의 변수 a="+a);
			System.out.println("외부의 변수 b="+b);
			System.out.println("외부의 변수 c="+c);
			System.out.println("외부의 변수 d="+d);
		}


	}//내부 끝

	static class InnerB{
		int e=50;
		static int f=60;
		public void showInnerB()
		{
			System.out.println("** static 내부 클래스의 메서드 **");
			//System.out.println("외부 a="+a);//이렇게 하면 에러난다. 왜 인스턴스 변수니까// 외부의 일반 인스턴스 멤버변수 접근 불가능
			System.out.println("외부 b="+b);
			System.out.println("내부 e="+e);
			System.out.println("내부 f="+f);

		}

	}

	//외부 클래스의 메서드 
	public void showOuter()
	{
		InnerA inA=new InnerA();
		inA.showInner();
		InnerB inB=new InnerB();
		inB.showInnerB();
	}
}

public class Ex08_InnerClass {

	public static void main(String[] args) {
		//1년에 한번 할까말까 그렇지만 알아만 둬라
		//보통은 내부에서 호출하지 이렇게 바깥에서 inner 클래스를 호출하는 경우가 거의 없다.
		
		OuterA a=new OuterA();
		a.showOuter();
		System.out.println();

		//다른 클래스에서 직접 내부 클래스의 메서드를 호출하고 싶을경우
		//거의 안씀
		//OuterA.InnerA b=new OuterA().new InnerA(); //자바스크립트 속성 접근법과 유사한 것 같다.
		OuterA.InnerA b=a.new InnerA(); //이렇게 쓴다.

		b.showInner();
		
		//static 내부 클래스를 직접 선언하여 메서드를 호출하고자 할 경우.
		OuterA.InnerB c=new OuterA.InnerB(); //바깥 클래스명으로 내부 클레스에 접근해서 하면된다.
		c.showInnerB(); 
	}

}
