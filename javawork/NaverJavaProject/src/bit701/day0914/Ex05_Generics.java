package bit701.day0914;


// <T> 는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용한다.
class GenericsType<T>
{
	T[] v;
	public void set(T[] n)
	{
		v=n;
	}
	
	public void print()
	{
		for(T s:v)
		{
			System.out.println(s+" ");
		}
		System.out.println();
	}
}

public class Ex05_Generics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []sarr= {"장미꽃","안개꽃","다알리아"};
		//T 에 대체되는 타입은 클래스 타입이나 인터페이스만 가능하다.
		GenericsType<String> t1= new GenericsType<>();//뒤에GenericsType<>() 에서 <>는 생략해도 된다.
		t1.set(sarr);
		t1.print();
		
		System.out.println("-".repeat(30));
//		GenericsType<int> t2=new GenericsType();//에러남  why? 클래스 타입이나 인터페이스만 가능하다.
		GenericsType<Integer> t2=new GenericsType();// 보내는건 int로 줘도 되는 이유. AutoBoxing
		//int 타입은 자동으로 Integer 타입으로 변형되서 들어간다(오토박싱 기능)
		Integer []narr= {5,7,10,30,100}; 
		// int []narr로 하면 에러발생, 여기서 오토박싱이 되는 부분은 Integer[]narr 배열안에 int 5~100이 들어가면서 변형된다.
		
		t2.set(narr);
		t2.print();
		
	}

}
