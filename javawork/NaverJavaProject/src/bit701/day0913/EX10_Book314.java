package bit701.day0913;

abstract class Tire
{
	abstract public void roll();
}

class HankookTire extends Tire
{

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("한국 타이어가 회전합니다.");	
	}
}

class KumhoTire extends Tire
{

	@Override
	public void roll() {
		// TODO Auto-generated method stub
		System.out.println("금호 타이어가 회전합니다.");// System 클래스의 변수 out 이 가지고 있는게 println임 static이다.
	}

}
//////////////////////////////////////////////////
class Car{
	public Tire tire;// 여기에 들어간 것에 따라 출력이 다르게 된다.
					 //초기값이 null.

	public void run()
	{
		tire.roll();// tire에 new로 생성을 안한 상태에서 호출시 NullPointerException 발생
	}
}

public class EX10_Book314 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Car car=new Car();
//		car.run(); //이렇게 하면 NullPointerException 발생
		
		Car car=new Car();
		car.tire=new HankookTire();
		car.run();
		
		car.tire=new KumhoTire();
		car.run();
	}

}
