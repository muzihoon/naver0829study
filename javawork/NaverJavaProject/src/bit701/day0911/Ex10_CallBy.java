package bit701.day0911;

public class Ex10_CallBy {

	//Call by value : 값만 전달된다(주소가 전달되지 않는다)
	//모든 기본형과 String 타입은 값만 전달된다. new로 생성된 인스턴스 변수들은 모두 주소가 전달되는데 String은 좀 독특함. 
	public static void changeInt(int a)
	{
		System.out.println("전달받은 a값:"+a);
		//a값을 변경
		a=20; //지역변수 a와 메인의 a의 주소가 서로 다르다.
		System.out.println("변경된 후 a 값:"+a);
	}
	
	//Call by Reference
	//기본형이 아닌 사용자 정의, 참조 타입
	//모든 배열은 주소가 전달(배열은 무조건 객체 타입으로 인식)
	public static void changeArray(int []arr)
	{
		System.out.println("전달받은 배열값 확인");
		for(int a:arr)
			System.out.print(a+"\t");
		System.out.println("\n1번지 값을 변경해보자");
		arr[1]=100;
	}
	public static void main(String[] args) {
		int a=10;
		changeInt(a);
		System.out.println("main a="+a);
		
		//메인의 a의 값이 변경되지 않는다. 
		
		
		int []arr= {3,4,5};
		changeArray(arr);//주소가 전달
		System.out.println("main 에서 arr 배열 확인");
		for(int n:arr)
			System.out.print(n+"\t"); //메서드 안에서 바꿨는데 메인의 값이 변경되어 있는걸 확인할 수 있다. 
		System.out.println();
	}
}
