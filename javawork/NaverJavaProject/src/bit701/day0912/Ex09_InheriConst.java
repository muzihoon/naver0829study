package bit701.day0912;

class SuperD
{
	private String carName;
	private String carColor;
	
	SuperD()
	{
		System.out.println("부모의 디폴트 생성자 호출");
		carName="소나타";
		carColor="노랑색";
	}
	
	SuperD(String carName,String carColor)
	{
		System.out.println("부모의 두번째 생성자 호출");
		this.carName=carName;
		this.carColor=carColor;
	
	}
	
	public void carInfo()
	{
		System.out.println("자동차명:"+carName);
		System.out.println("자동차색상:"+carColor);
	}
}

class SubD extends SuperD
{
	private int carPrice;
	
	SubD()
	{
		System.out.println("sub 디폴트 생성자");
		this.carPrice=3500;
	}
	
	SubD(String carName,String carColor, int carPirce)
	{
		super(carName,carColor); // 반드시 있어야함 없으면 기본형으로 호출된다. 
		System.out.println("sub의 두번째 생성자");
		this.carPrice=carPirce;
	}
	
	@Override
	public void carInfo() {
		// TODO Auto-generated method stub
		super.carInfo();//부모의 멤버변수가 private 이라 부모가 출력 후 메서드로 호출
		System.out.println("차량 가격 : "+this.carPrice);
		System.out.println("========================================");
	}
}

////////////////////////////////////////
public class Ex09_InheriConst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubD sub1=new SubD(); //부모 호출 , sub 디폴트 생성자 호출 예상
		sub1.carInfo();
		
		SubD sub2=new SubD("벤츠","검정색",6700); //부모 먼저 호출 디폴트값 나오고 그다음 값 변경, 두번째 생성자 호출 문구, 금액은 6700
		sub2.carInfo();
		
	}

}

//교재 284-상속 

//p290 예제 ~p297
