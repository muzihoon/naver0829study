package bit701.day0913;

class Parent
{
	public void mehtod1()
	{
		System.out.println("Parent-method1");
	}
	
	public void mehtod2()
	{
		System.out.println("Parent-method2");
	}
}

//상속받는 클래스 구현
class Child extends Parent
{
	@Override
	public void mehtod2() {
		// TODO Auto-generated method stub
		System.out.println("Childe-method2"); //this로 호출된다. 부모꺼 호출하고 싶으면 super(method2);로 해야함
		
	}
	
	public void method3()
	{
		System.out.println("Childe-method3");
		
	}
}

public class EX09_Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Child a=new Child(); //선언을 자식으로 했을 경우에는 
		a.mehtod1(); //부모꺼
		a.mehtod2(); //자기 자신거
		a.method3(); //자기 자신거, 전부 가능함 
		System.out.println("----------------------------------");
		Parent b = new Child(); //선언을 부모로 했을 경우에는 
		b.mehtod1();
		b.mehtod2();
		//b.mehtod3(); //오류발생, child의 오버라이드 한 메서드만 호출 가능
		((Child)b).method3(); //강제로 Child로 형현환후 호출이 가능은 하다. 상속 관계일때도 형변환이 가능하다.
		// 이렇게는 보통 부모를 자식으로 형변환 할때 많이 사용한다.
		
		
		
	}

}
