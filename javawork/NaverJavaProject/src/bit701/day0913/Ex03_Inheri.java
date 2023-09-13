package bit701.day0913;


//다형성 처리시 부모가 하는일이 없을경우 어떻게 해야 할까요?
//오버라이딩을 위해서 일단 부모의 메서드는 만들어야 한다.

//추상클래스의 특징
/*
 *1. 일반 메서드와 미완성의 abstract 메서드 둘다 구현 가능하다.
 *2. abstrac(추상)클래스는 new로 객체 생성을 할 수 없다
 *3. 추상 클래스를 상속받는 클래스는 반드시 추상 메서드를 오버라이드 해서 기능을 구현해야만 한다.
 *4. 만약 추상 메소드를 오버라이드 안한 경우 서브클래스도 역시 추상화 시켜야만 한다.
 * */


abstract class SuperColor
{
//	public void draw()
//	{
//		//부모클래스가 하는일이 없으므로 안에 내용도 없음 
//	}
	//오버라이드를 위해서 {} 부분을 없앤다.
	
	//오버라이드를 안할경우 호출 가능
	//서브클레스에만 있는 메서드는 호출 불가능(부모로 선언시)
	//class의 멤버메서드중 한개 이상의 추상 메소드가 있는 경우
	//반드시 클래스도 추상화시켜야한다. 즉 class 앞에 abstract를 붙인다.
	
	abstract public void draw();
	
	public void parentJob()
	{
		System.out.println("부모는 오늘도 돈을 벌어온다");
	}
}

//3개의 서브 클래스 생성
class SubRed extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("집안 청소를 한다.");
				
	}
}

//3개의 서브 클래스 생성
class SubGreen extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("식사준비를 한다.");
				
	}
}

//3개의 서브 클래스 생성
class SubBlue extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("설거지를 한다.");
				
	}
}
public class Ex03_Inheri {

	
	public static void draw(SuperColor s)
	{
		s.draw();
		s.parentJob();//부모가 갖고있는 메소드 호출(오버라이드 x)
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//자바는 객체를 생성하고 바로 메서드에 전달하는 방법을 사용할 수 있다.
		//변수 a에 객체를 생성하고 전달하는 방법보다 더 간결하게 할 수 있는 방법이다.
		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());
	}

}
