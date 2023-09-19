package bit701.day0916;

class Tire{
	public void roll() 
	{
		System.out.println("일반 타이어가 굴러갑니다.");
	}
} 

class Car{
	//필드에 Tire 객체 대입
	private Tire tire1 = new Tire();

	//필드에 익명 자식 객체 대입
	private Tire tire2 = new Tire()
	{
		@Override
		public void roll() {
			System.out.println("익명 자식 Tire 객체 1이 굴러갑니다.");
		}
	};

	//메소드(필드 이용)
	public void run1() {
		tire1.roll();
		tire2.roll();
	}

	//메소드 (로컬 변수 이용)
	public void run2() {
		//로컬 변수에 익명 자식 객체 대입
		Tire tire = new Tire() {
			public void roll() {
				System.out.println("익명 자식 Tire 객체 2가 굴러갑니다.");
			}
		};
		tire.roll();
		
	}//메서드 2 끝
	
	//메소드(매개변수 이용)
	public void run3(Tire tire)
	{
		tire.roll();
	}
	
}//car 끝


public class Ex01_Anonymous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Car 객체 생성
		Car car = new Car();
		
		//익명 자식 객체가 대입된 필드 사용
		car.run1();
		
		//익명 자식 객체가 대입된 로컬변수 사용
		car.run2();
		
		//익명 자식 객체가 대입된 매개변수 사용
		car.run3(new Tire(){
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체 3이 굴러갑니다.");
			}
		});
		
	}

}
