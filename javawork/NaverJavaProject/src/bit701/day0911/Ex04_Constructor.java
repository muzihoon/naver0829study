package bit701.day0911;
class Car
{	
	
	/* 
	 * 1.
	 * 2.
	 * 3.
	 * 4.
	 *  */
	
	private String carName;
	private int carPrice;
	//디폴트 생성자
	Car()
	{
		System.out.println("디폴트 생성자 호출");
		carName="그랜저";
		carPrice=3500;
	}
	
	//생성자를 통해서 외부에서 값을 받아서 초기화
	Car(String carName, int carPrice)
	{
		System.out.println("생성자 2 호출");
		this.carName=carName;
		this.carPrice=carPrice;
	}
	
	public void carShow()
	{
		System.out.println("자동차명 : "+carName+",단가"+carPrice);
	}
}

public class Ex04_Constructor {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1= new Car();
		car1.carShow();
		
		Car car2=new Car("아반떼",2700);
		car2.carShow();
	}

}
