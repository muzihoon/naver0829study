package bit701.day0911;

class Apple{
	
	//오버로딩 실습 예제. 
	// 타입 or 매개변수의 개수가 달라야한다.
	public static int sum(int a, int b)
	{
		System.out.println(1);
		return a+b;
	}
	
	public static int sum(int s1, int s2, int s3)
	{
		return s1+s2+s3;
	}
	
//	public static double sum (double a, double b)
//	{
//		return a+b;
//		
//	}
	
	public static String sum (String a, String b)
	{
		return a+b;
	}
	
	public static String sum(String a, int b)
	{
		return a+b;
	}
	
	//... Variable Argument
	public static int sum(int...n)//n은 배열타, 숫자 갯수 상관없이 int 타입으로 받는다. jdk5.0 이후 사용가능
	{
		System.out.println(2);
		System.out.println("총 "+n.length);
		return 0;
	}
}


public class Ex02_Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1 = Apple.sum(5,7);
		System.out.println(s1);
		System.out.println(Apple.sum(5, 7));
		System.out.println(Apple.sum("apple", "orange"));
//		System.out.println(Apple.sum(1.2,4.5));
		//System.out.println(100,"orange");//오류
		System.out.println(Apple.sum(100,200,300));
		//System.out.println(Apple.sum(100,200,300,400));//오류
		
	}

}
