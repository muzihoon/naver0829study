package bit701.day0913;

//1번 예제의 메서드들을 호출해보자.

public class Ex02_Inheri {
	
	//인자를 SubA로 하면 SubA만 보낼 수 있다.
	public static void processPlay(SubA sub)
	{
		sub.process();
	}
	public static void processPlay(SubB sub)
	{
		sub.process();
	}
	public static void processPlay(SubC sub)
	{
		sub.process();
	}
	
	
	//위 3개의 메서드를 하나로 줄여서 만드려면
	//인자를 부모클래스로 선언하면 된다 Buffe
	public static void processPlay(SuperA sub)
	{
		//자식의 서브클래스의 메서드중 호출 할 수 있는 메서드는 오버라이딩 메서드 뿐이다.->중요한 메서드는 오버라이딩 해서 만든다.
		//서브클래스라고 하는 이유는 부모가 가지고 있는 메서드는 호출 가능함.
		sub.process();//sub 변수에 누가 생성되어 있느냐에 따라서 하는일이 달라진다.(다형성)
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());
		
		
		//실행결과- 부모가 처리하는 일이 많지 않다. 그래도 만들어야 한다. 왜냐면 오버라이딩 해야하니까. 
	}

}
